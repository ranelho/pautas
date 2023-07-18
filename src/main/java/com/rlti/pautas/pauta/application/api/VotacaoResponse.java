package com.rlti.pautas.pauta.application.api;

import com.rlti.pautas.pauta.domain.Votacao;
import lombok.Data;

import java.util.List;

@Data
public class VotacaoResponse {
    String associado;
    String voto;

    public VotacaoResponse(Votacao votacao) {
        this.voto = votacao.getVoto().toString();
        this.associado = votacao.getAssociado().getFullName();
    }
    public static List<VotacaoResponse> converte(List<Votacao> exames) {
        return exames.stream().map(VotacaoResponse::new).toList();
    }
}
