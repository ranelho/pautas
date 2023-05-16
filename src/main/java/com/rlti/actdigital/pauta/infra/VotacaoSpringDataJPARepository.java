package com.rlti.actdigital.pauta.infra;

import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotacaoSpringDataJPARepository  extends JpaRepository<Votacao, Long> {
    Optional<Votacao> findByAssociadoAndPauta(Associado associado, Pauta pauta);
}
