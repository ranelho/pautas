package com.rlti.pautas.associados.application.api;

import com.rlti.pautas.associados.application.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<AssociadoResponse> getAllAssociados(Pageable pageable) {
        log.info("[inicia] AssociadoRestController.getAllAssociados");
        Page<AssociadoResponse> list = associadoService.getAllAssociados(pageable);
        log.info("[finaliza] AssociadoRestController.getAllAssociados");
        return list;
    }

    @Override
    public AssociadoResponse updateAssociado(String cpf, AssociadoUpdateRequest request) {
        log.info("[inicia] AssociadoRestController.updateAssociado");
        AssociadoResponse response = associadoService.updateAssociado(cpf, request);
        log.info("[finaliza] AssociadoRestController.updateAssociado");
        return response;
    }
}
