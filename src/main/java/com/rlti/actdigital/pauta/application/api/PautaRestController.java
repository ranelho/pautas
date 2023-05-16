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
        log.info("[inicio] PautaRestController.createPauta");
        PautaResponse  response = pautaService.createPauta(request);
        log.info("[fim] PautaRestController.createPauta");
        return response;
    }
}
