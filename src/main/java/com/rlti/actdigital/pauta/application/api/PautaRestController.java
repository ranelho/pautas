package com.rlti.actdigital.pauta.application.api;

import com.rlti.actdigital.pauta.application.service.PautaService;
import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.infra.PautaSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaRestController implements PautaApi {
    private final PautaService pautaService;

    @Override
    public PautaResponse createPauta(PautaRequest request) {
        log.info("[inicia] PautaRestController.createPauta");
        PautaResponse  response = pautaService.createPauta(request);
        log.info("[finaliza] PautaRestController.createPauta");
        return response;
    }

    @Override
    public VotacaoResponse createVotacao(VotacaoRequest request) {
        log.info("[inicia] PautaRestController.createVotacao");
        VotacaoResponse response = pautaService.createVotacao(request);
        log.info("[finaliza] PautaRestController.createVotacao");
        return response;
    }

    @Override
    public ResultadoResponse getResultado(Long idPauta) {
        log.info("[inicia] PautaRestController.getResultado");
        ResultadoResponse response = pautaService.getResultado(idPauta);
        log.info("[finaliza] PautaRestController.getResultado");
        return response;
    }

    @Override
    public PautaResponse getPauta(Long idPauta) {
        log.info("[inicia] PautaRestController.getPauta");
        PautaResponse response = pautaService.getPauta(idPauta);
        log.info("[finaliza] PautaRestController.getPauta");
        return response;
    }
}
