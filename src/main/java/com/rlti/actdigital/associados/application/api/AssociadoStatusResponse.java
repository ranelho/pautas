package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.domain.Associado;
import lombok.Data;

@Data
public class AssociadoStatusResponse {
    String status;

    public AssociadoStatusResponse(Associado associado) {
        this.status = associado.getStatus().toString();
    }
}
