package com.rlti.pautas.pauta.application.service;

import com.rlti.pautas.associados.application.repository.AssociadoRepository;
import com.rlti.pautas.associados.domain.Associado;
import com.rlti.pautas.config.TimeSynchronizer;
import com.rlti.pautas.pauta.application.api.*;
import com.rlti.pautas.pauta.application.repository.PautaRepository;
import com.rlti.pautas.pauta.application.repository.VotacaoRepository;
import com.rlti.pautas.pauta.domain.Pauta;
import com.rlti.pautas.pauta.domain.Votacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.rlti.pautas.associados.domain.Status.UNABLE_TO_VOTE;
import static com.rlti.pautas.handler.APIException.build;
import static java.time.temporal.ChronoUnit.MINUTES;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;
    private final VotacaoRepository votacaoRepository;
    private final AssociadoRepository associadoRepository;
    private final TimeSynchronizer timeSynchronizer;

    @Override
    public PautaResponse createPauta(final PautaRequest request) {
        log.info("[inicia] PautaApplicationService.createPauta");
        Optional<Pauta> existePauta =
                pautaRepository.getByDescricaoAndHoraInicio(request.descricao(), request.horarioInicio());
        if (existePauta.isPresent()) {
            throw build(BAD_REQUEST, "Pauta %s já cadastrada!".formatted(existePauta.get().getDescricao()));
        } else {
            Pauta pauta = pautaRepository.salva(new Pauta(request));
            log.info("[finaliza] PautaApplicationService.createPauta");
            return new PautaResponse(pauta);
        }
    }

    @Override
    public VotacaoResponse createVotacao(final Long idPauta, final VotacaoRequest request) {
        log.info("[inicia] PautaApplicationService.createVotacao");
        Pauta pauta = pautaRepository.getById(idPauta);
        Associado associado = getAssociado(request.cpf());
        votacaoRepository.findByAssociadoAndPauta(associado, pauta);
        validaVotacao(pauta, associado);
        Votacao votacao = votacaoRepository.salva(new Votacao(request, associado, pauta));
        log.info("[finaliza] PautaApplicationService.createVotacao");
        return new VotacaoResponse(votacao);
    }

    @Override
    public ResultadoResponse getResultado(Long idPauta) {
        log.info("[inicia] PautaApplicationService.getResultado");
        List<Votacao> votacoes = votacaoRepository.findByPauta(pautaRepository.getById(idPauta));
        return new ResultadoResponse(votacoes, pautaRepository.getById(idPauta));
    }

    @Override
    public PautaResponse getPauta(Long idPauta) {
        log.info("[inicia] PautaApplicationService.getPauta");
        Pauta pauta = pautaRepository.getById(idPauta);
        log.info("[finaliza] PautaApplicationService.getPauta");
        return new PautaResponse(pauta);
    }

    @Override
    public PautaResponse updatePauta(Long idPauta, PautaRequest request) {
        log.info("[inicia] PautaApplicationService.updatePauta");
        Pauta pauta = pautaRepository.getById(idPauta);
        pauta.update(request);
        Pauta pautaAtualizada = pautaRepository.salva(pauta);
        log.info("[finaliza] PautaApplicationService.updatePauta");
        return new PautaResponse(pautaAtualizada);
    }

    private void validaVotacao(Pauta pauta, Associado associado) {
        LocalDateTime now = timeSynchronizer.getCurrentTime();
        if (now.isBefore(pauta.getHorarioInicio())) {
            throw build(BAD_REQUEST, "A votação ainda não começou! Faltam "
                    + MINUTES.between(now, pauta.getHorarioInicio()) + " minuto(s) para o início.");
        }
        if (now.isAfter(pauta.getHorarioFim()))
            throw build(BAD_REQUEST, "Horário de votação encerrado");
        if (associado.getStatus().equals(UNABLE_TO_VOTE))
            throw build(BAD_REQUEST, "Associado não pode votar nesta pauta");
    }

    private Associado getAssociado(String cpf) {
        return associadoRepository.findByCpf(cpf)
                .orElseThrow(() -> build(BAD_REQUEST, "Cpf %s não encontrado!".formatted(cpf)));
    }
}