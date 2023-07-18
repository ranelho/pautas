package com.rlti.pautas.pauta.application.api;

import com.rlti.pautas.pauta.domain.Votacao;

import java.util.List;

public record VotacaoResponse ( String associado, String voto) {

    public VotacaoResponse(Votacao votacao){
        this(votacao.getAssociado().getFullName(), votacao.getVoto().toString());
    }

    public static List<VotacaoResponse> converte(List<Votacao> exames) {
        return exames.stream().map(VotacaoResponse::new).toList();
    }
}
