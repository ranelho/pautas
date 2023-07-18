package com.rlti.pautas.associados.application.service;

import com.rlti.pautas.associados.application.api.AssociadoRequest;
import com.rlti.pautas.associados.application.api.AssociadoResponse;
import com.rlti.pautas.associados.application.api.AssociadoStatusResponse;
import com.rlti.pautas.associados.application.api.AssociadoUpdateRequest;

import java.util.List;

public interface AssociadoService {
    AssociadoResponse newAssociado(AssociadoRequest associadoRequest);
    AssociadoResponse getAssociadoByCpf(String cpf);
    AssociadoStatusResponse updateStatusAssociado(String cpf);
    List<AssociadoResponse> getAllAssociados();
    AssociadoResponse updateAssociado(String cpf, AssociadoUpdateRequest request);
}