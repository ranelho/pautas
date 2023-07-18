package com.rlti.pautas.pauta.infra;

import com.rlti.pautas.pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, Long> {
    Optional<Pauta> findByDescricaoAndHorarioInicio(String descricao, LocalDateTime horarioInicio);
}
