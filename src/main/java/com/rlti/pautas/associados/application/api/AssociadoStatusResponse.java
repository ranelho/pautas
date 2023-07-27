package com.rlti.pautas.associados.application.api;

import com.rlti.pautas.associados.domain.Associado;

public record AssociadoStatusResponse (
        String status
)  {
    public AssociadoStatusResponse(Associado associado) {
        this(associado.getStatus().toString());
    }
}
