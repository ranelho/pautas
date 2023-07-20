package com.rlti.pautas.associados.application.service;

import com.rlti.pautas.associados.application.api.AssociadoRequest;
import com.rlti.pautas.associados.application.api.AssociadoResponse;
import com.rlti.pautas.associados.application.api.AssociadoStatusResponse;
import com.rlti.pautas.associados.application.api.AssociadoUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AssociadoService {
    AssociadoResponse newAssociado(AssociadoRequest associadoRequest);
    AssociadoResponse getAssociadoByCpf(String cpf);
    AssociadoStatusResponse updateStatusAssociado(String cpf);
    AssociadoResponse updateAssociado(String cpf, AssociadoUpdateRequest request);
    Page<AssociadoResponse> getAllAssociados(Pageable pageable);
}