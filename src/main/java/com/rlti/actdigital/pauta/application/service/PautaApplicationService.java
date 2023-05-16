package com.rlti.actdigital.pauta.application.service;

import com.rlti.actdigital.associados.application.repository.AssociadoRepository;
import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.associados.domain.Status;
import com.rlti.actdigital.handler.APIException;
import com.rlti.actdigital.pauta.application.api.*;
import com.rlti.actdigital.pauta.application.repository.PautaRepository;
import com.rlti.actdigital.pauta.application.repository.VotacaoRepository;
import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.domain.Votacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;
    private final VotacaoRepository votacaoRepository;
    private final AssociadoRepository associadoRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    LocalDateTime now = LocalDateTime.parse(formatter.format(LocalDateTime.now()));

    @Override
    public PautaResponse createPauta(PautaRequest request) {
        log.info("[inicia] PautaApplicationService.createPauta");
        Optional<Pauta> existePauta = pautaRepository.getByDescricaoAndHoraInicio(request.getDescricao(),
                request.getHorarioInicio());
        if(existePauta.isEmpty()) {
            Pauta pauta = pautaRepository.salva(new Pauta(request));
            log.info("[finaliza] PautaApplicationService.createPauta");
            return new PautaResponse(pauta);
        }else {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Pauta já cadastrada, id: "
                    + existePauta.get().getIdPauta());
        }
    }

    @Override
    public VotacaoResponse createVotacao(VotacaoRequest request) {

        log.info("[inicia] PautaApplicationService.createVotacao");
        Pauta pauta = pautaRepository.getById(request.getIdPauta());
        Associado associado = associadoRepository.findByCpf(request.getCpf());
        Optional<Votacao> jaVotou = votacaoRepository.findByAssociadoAndPauta(associado, pauta);
        if (now.isBefore(pauta.getHorarioInicio()))
            throw APIException.build(HttpStatus.BAD_REQUEST, "Horário de votação ainda não começou");
        if (now.isAfter(pauta.getHorarioFim()))
            throw APIException.build(HttpStatus.BAD_REQUEST, "Horário de votação encerrado");
        if (jaVotou.isPresent())
            throw APIException.build(HttpStatus.BAD_REQUEST, "Associado já votou nesta pauta");
        if (associado.getStatus().equals(Status.UNABLE_TO_VOTE))
            throw APIException.build(HttpStatus.BAD_REQUEST, "Associado não pode votar nesta pauta");
        Votacao votacao = votacaoRepository.salva(new Votacao(request, associado, pauta));
        log.info("[finaliza] PautaApplicationService.createVotacao");
        return new VotacaoResponse(votacao);
    }

    @Override
    public ResultadoResponse getResultado(Long idPauta) {
        log.info("[inicia] PautaApplicationService.getResultado");
        List<Votacao> votacoes = votacaoRepository.findByPauta(pautaRepository.getById(idPauta));
        return new ResultadoResponse(votacoes);
    }

    @Override
    public PautaResponse getPauta(Long idPauta) {
        log.info("[inicia] PautaApplicationService.getPauta");
        Pauta pauta = pautaRepository.getById(idPauta);
        log.info("[finaliza] PautaApplicationService.getPauta");
        return new PautaResponse(pauta);
    }
}
