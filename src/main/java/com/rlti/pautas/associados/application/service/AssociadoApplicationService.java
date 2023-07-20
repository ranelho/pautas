package com.rlti.pautas.associados.application.service;

import com.rlti.pautas.associados.application.api.AssociadoRequest;
import com.rlti.pautas.associados.application.api.AssociadoResponse;
import com.rlti.pautas.associados.application.api.AssociadoStatusResponse;
import com.rlti.pautas.associados.application.api.AssociadoUpdateRequest;
import com.rlti.pautas.associados.application.repository.AssociadoRepository;
import com.rlti.pautas.associados.domain.Associado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rlti.pautas.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponse newAssociado(final AssociadoRequest request) {
        log.info("[inicia] AssociadoApplicationService.newAssociado");
        Associado associado = associadoRepository.save(new Associado(request));
        log.info("[finaliza] AssociadoApplicationService.newAssociado");
        return new AssociadoResponse(associado);
    }

    @Override
    public AssociadoResponse getAssociadoByCpf(String cpf) {
        log.info("[inicia] AssociadoApplicationService.getAssociadoByCpf");
        Associado associado = getAssociado(cpf);
        log.info("[finaliza] AssociadoApplicationService.getAssociadoByCpf");
        return new AssociadoResponse(associado);
    }

    @Override
    public AssociadoStatusResponse updateStatusAssociado(String cpf) {
        log.info("[inicia] AssociadoApplicationService.updateStatusAssociado");
        Associado associado = getAssociado(cpf);
        associado.newStatus();
        associadoRepository.save(associado);
        log.info("[finaliza] AssociadoApplicationService.updateStatusAssociado");
        return new AssociadoStatusResponse(associado);
    }

    @Override
    public AssociadoResponse updateAssociado(String cpf, AssociadoUpdateRequest request) {
        log.info("[inicia] AssociadoApplicationService.updateAssociado");
        Associado associado = getAssociado(cpf);
        associado.update(request);
        associadoRepository.save(associado);
        log.info("[finaliza] AssociadoApplicationService.updateAssociado");
        return new AssociadoResponse(associado);
    }

    @Override
    public Page<AssociadoResponse> getAllAssociados(Pageable pageable) {
        log.info("[inicia] AssociadoApplicationService.getAllAssociados");
        Page<Associado> associados = associadoRepository.findAll(pageable);
        log.info("[finaliza] AssociadoApplicationService.getAllAssociados");
        return AssociadoResponse.pageConverte(associados);
    }

    private Associado getAssociado(String cpf) {
        return associadoRepository.findByCpf(cpf)
                .orElseThrow(() -> build(BAD_REQUEST, "Cpf %s não encontrado!".formatted(cpf)));
    }
}
