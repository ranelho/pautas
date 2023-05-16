package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.application.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AssociadoRestController implements AssociadoApi {
    private final AssociadoService associadoService;

    @Override
    public AssociadoResponse newAssociado(AssociadoRequest associadoRequest) {
        log.info("[inicia] AssociadoRestController.newAssociado");
        AssociadoResponse associadoResponse = associadoService.newAssociado(associadoRequest);
        log.info("[fim] AssociadoRestController.newAssociado");
        return associadoResponse;
    }
}
