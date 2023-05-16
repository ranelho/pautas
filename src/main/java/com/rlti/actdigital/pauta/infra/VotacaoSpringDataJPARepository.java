package com.rlti.actdigital.pauta.infra;

import com.rlti.actdigital.pauta.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoSpringDataJPARepository  extends JpaRepository<Votacao, Long> {
}
