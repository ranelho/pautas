package com.rlti.actdigital.pauta.application.api;

import com.rlti.actdigital.pauta.domain.Votacao;
import lombok.Data;

@Data
public class VotacaoResponse {
    Long idVoto;
    String voto;
    String associado;

    public VotacaoResponse(Votacao votacao) {
        this.idVoto = votacao.getIdVoto();
        this.voto = votacao.getVoto().toString();
        this.associado = votacao.getAssociado().getFullName();
    }
}
