package com.rlti.pautas.associados.application.api;

import com.rlti.pautas.associados.domain.Associado;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public record AssociadoResponse (
        UUID idAssociado, String fullName, String cpf, String status
) {
    public AssociadoResponse(Associado associado) {
       this(associado.getIdAssociado(), associado.getFullName(), associado.getCpf(), associado.getStatus().toString());
    }
    public static List<AssociadoResponse> converte(List<Associado> associados) {
        return associados.stream().map(AssociadoResponse::new).toList();
    }
    public static Page<AssociadoResponse> pageConverte(Page<Associado> associados) {
        return associados.map(AssociadoResponse::new);
    }
}