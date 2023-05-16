package com.rlti.actdigital.pauta.application.repository;

import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.domain.Votacao;

import java.util.Optional;

public interface VotacaoRepository {
    Votacao salva(Votacao votacao);
    Optional<Votacao> findByAssociadoAndPauta(Associado associado, Pauta pauta);
}
