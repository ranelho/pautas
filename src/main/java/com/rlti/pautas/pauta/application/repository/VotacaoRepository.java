package com.rlti.pautas.pauta.application.repository;

import com.rlti.pautas.associados.domain.Associado;
import com.rlti.pautas.pauta.domain.Pauta;
import com.rlti.pautas.pauta.domain.Votacao;

import java.util.List;

public interface VotacaoRepository {
    Votacao salva(Votacao votacao);
    void findByAssociadoAndPauta(Associado associado, Pauta pauta);
    List<Votacao> findByPauta(Pauta byId);
}
