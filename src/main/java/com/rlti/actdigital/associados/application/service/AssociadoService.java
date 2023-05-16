package com.rlti.actdigital.associados.application.service;

import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.associados.application.api.AssociadoResponse;
import com.rlti.actdigital.associados.application.api.AssociadoStatusResponse;

import java.util.List;

public interface AssociadoService {
    AssociadoResponse newAssociado(AssociadoRequest associadoRequest);
    AssociadoResponse getAssociadoByCpf(String cpf);
    AssociadoStatusResponse updateStatusAssociado(String cpf);
    List<AssociadoResponse> getAllAssociados();
}
