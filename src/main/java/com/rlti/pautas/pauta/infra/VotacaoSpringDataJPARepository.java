package com.rlti.pautas.pauta.infra;

import com.rlti.pautas.associados.domain.Associado;
import com.rlti.pautas.pauta.domain.Pauta;
import com.rlti.pautas.pauta.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotacaoSpringDataJPARepository  extends JpaRepository<Votacao, Long> {
    Optional<Votacao> findByAssociadoAndPauta(Associado associado, Pauta pauta);
    List<Votacao> findByPauta(Pauta byId);
}
