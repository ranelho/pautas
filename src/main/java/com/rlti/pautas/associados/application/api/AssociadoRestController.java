package com.rlti.pautas.associados.application.api;

import com.rlti.pautas.associados.application.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AssociadoRestController implements AssociadoApi {
    private final AssociadoService associadoService;

    @Override
    public AssociadoResponse newAssociado(AssociadoRequest request) {
        log.info("[inicia] AssociadoRestController.newAssociado");
        AssociadoResponse response = associadoService.newAssociado(request);
        log.info("[finaliza] AssociadoRestController.newAssociado");
        return response;
    }

    @Override
    public AssociadoResponse getAssociadoByCpf(String cpf) {
        log.info("[inicia] AssociadoRestController.getAssociadoByCpf");
        AssociadoResponse response = associadoService.getAssociadoByCpf(cpf);
        log.info("[finaliza] AssociadoRestController.getAssociadoByCpf");
        return response;
    }

    @Override
    public AssociadoStatusResponse updateStatusAssociado(String cpf) {
        log.info("[inicia] AssociadoRestController.updateStatusAssociado");
        AssociadoStatusResponse status = associadoService.updateStatusAssociado(cpf);
        log.info("[finaliza] AssociadoRestController.updateStatusAssociado");
        return status;
    }

    @Override
    public List<AssociadoResponse> getAllAssociados() {
        log.info("[inicia] AssociadoRestController.getAllAssociados");
        List<AssociadoResponse> list = associadoService.getAllAssociados();
        log.info("[finaliza] AssociadoRestController.getAllAssociados");
        return list;
    }
}
