package com.rlti.actdigital.associados.application.service;

import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.associados.application.api.AssociadoResponse;

public interface AssociadoService {
    AssociadoResponse newAssociado(AssociadoRequest associadoRequest);
}
