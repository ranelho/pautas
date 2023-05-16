package com.rlti.actdigital.pauta.application.api;

import com.rlti.actdigital.pauta.application.service.PautaService;
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
}
