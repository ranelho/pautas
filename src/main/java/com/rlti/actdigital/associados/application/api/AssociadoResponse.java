package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.domain.Associado;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

@Value
public class AssociadoResponse {
    UUID idAssociado;
    String fullName;
    String cpf;
    String status;

    public AssociadoResponse(Associado associado) {
        this.idAssociado = associado.getIdAssociado();
        this.fullName = associado.getFullName();
        this.cpf = associado.getCpf();
        this.status = associado.getStatus().toString();
    }
    public static List<AssociadoResponse> converte(List<Associado> associados) {
        return associados.stream().map(AssociadoResponse::new).toList();
    }
}
