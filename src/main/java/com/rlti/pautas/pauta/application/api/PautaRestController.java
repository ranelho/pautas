package com.rlti.pautas.pauta.application.api;

import com.rlti.pautas.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaRestController implements PautaApi {
    private final PautaService pautaService;

    @Override
    public PautaResponse createPauta(PautaRequest request) {
        log.info("[inicia] PautaRestController.createPauta");
        PautaResponse response = pautaService.createPauta(request);
        log.info("[finaliza] PautaRestController.createPauta");
        return response;
    }

    @Override
    public VotacaoResponse createVotacao(Long idPauta, VotacaoRequest request) {
        log.info("[inicia] PautaRestController.createVotacao");
        VotacaoResponse response = pautaService.createVotacao(idPauta, request);
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

    @Override
    public PautaResponse updatePauta(Long idPauta, PautaRequest request) {
        log.info("[inicia] PautaRestController.updatePauta");
        PautaResponse response = pautaService.updatePauta(idPauta, request);
        log.info("[finaliza] PautaRestController.updatePauta");
        return response;
    }
}