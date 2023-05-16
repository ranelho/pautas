package com.rlti.actdigital.pauta.application.service;

import com.rlti.actdigital.associados.application.repository.AssociadoRepository;
import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.handler.APIException;
import com.rlti.actdigital.pauta.application.api.PautaRequest;
import com.rlti.actdigital.pauta.application.api.PautaResponse;
import com.rlti.actdigital.pauta.application.api.VotacaoRequest;
import com.rlti.actdigital.pauta.application.api.VotacaoResponse;
import com.rlti.actdigital.pauta.application.repository.PautaRepository;
import com.rlti.actdigital.pauta.application.repository.VotacaoRepository;
import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.domain.Votacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;
    private final VotacaoRepository votacaoRepository;
    private final AssociadoRepository associadoRepository;

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
        Votacao votacao = votacaoRepository.salva(new Votacao(request.getVoto(), associado, pauta));
        log.info("[finaliza] PautaApplicationService.createVotacao");
        return new VotacaoResponse(votacao);
    }
}
