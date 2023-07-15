package com.rlti.actdigital.associados.application.service;

import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.associados.application.api.AssociadoResponse;
import com.rlti.actdigital.associados.application.api.AssociadoStatusResponse;
import com.rlti.actdigital.associados.application.repository.AssociadoRepository;
import com.rlti.actdigital.associados.domain.Associado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponse newAssociado(final AssociadoRequest associadoRequest) {
        log.info("[inicia] AssociadoApplicationService.newAssociado");
        Associado associado = associadoRepository.save(new Associado(associadoRequest));
        log.info("[finaliza] AssociadoApplicationService.newAssociado");
        return new AssociadoResponse(associado);
    }

    @Override
    public AssociadoResponse getAssociadoByCpf(String cpf) {
        log.info("[inicia] AssociadoApplicationService.getAssociadoByCpf");
        Associado associado = associadoRepository.findByCpf(cpf);
        log.info("[finaliza] AssociadoApplicationService.getAssociadoByCpf");
        return new AssociadoResponse(associado);
    }

    @Override
    public AssociadoStatusResponse updateStatusAssociado(String cpf) {
        log.info("[inicia] AssociadoApplicationService.updateStatusAssociado");
        Associado associado = associadoRepository.findByCpf(cpf);
        associado.newStatus();
        associadoRepository.save(associado);
        log.info("[finaliza] AssociadoApplicationService.updateStatusAssociado");
        return new AssociadoStatusResponse(associado);
    }

    @Override
    public List<AssociadoResponse> getAllAssociados() {
        log.info("[inicia] AssociadoApplicationService.getAllAssociados");
        List<Associado> associados = associadoRepository.findAll();
        log.info("[finaliza] AssociadoApplicationService.getAllAssociados");
        return AssociadoResponse.converte(associados);
    }
}
