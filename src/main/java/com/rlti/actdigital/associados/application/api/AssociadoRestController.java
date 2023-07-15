package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.application.service.AssociadoService;
import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.associados.infra.AssociadoSprigDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AssociadoRestController implements AssociadoApi {
    private final AssociadoService associadoService;
    private final AssociadoSprigDataJPARepository jpaRepository;

    @Override
    public AssociadoResponse newAssociado(AssociadoRequest request) {
        log.info("[inicia] AssociadoRestController.newAssociado");
        AssociadoResponse associadoResponse = associadoService.newAssociado(request);
        log.info("[fim] AssociadoRestController.newAssociado");
        return associadoResponse;
    }

    @Override
    public AssociadoResponse getAssociadoByCpf(String cpf) {
        log.info("[inicia] AssociadoRestController.getAssociadoByCpf");
        AssociadoResponse associadoResponse = associadoService.getAssociadoByCpf(cpf);
        log.info("[finaliza] AssociadoRestController.getAssociadoByCpf");
        return associadoResponse;
    }

    @Override
    public AssociadoStatusResponse updateStatusAssociado(String cpf) {
        log.info("[inicia] AssociadoRestController.updateStatusAssociado");
        AssociadoStatusResponse associadoStatusResponse = associadoService.updateStatusAssociado(cpf);
        log.info("[finaliza] AssociadoRestController.updateStatusAssociado");
        return associadoStatusResponse;
    }

    @Override
    public List<AssociadoResponse> getAllAssociados() {
        log.info("[inicia] AssociadoRestController.getAllAssociados");
        List<AssociadoResponse> associadoResponseList = associadoService.getAllAssociados();
        log.info("[finaliza] AssociadoRestController.getAllAssociados");
        return associadoResponseList;
    }

}
