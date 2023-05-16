package com.rlti.actdigital.pauta.application.repository;

import com.rlti.actdigital.pauta.domain.Pauta;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
    Optional<Pauta> getByDescricaoAndHoraInicio(String descricao, LocalDateTime horarioInicio);
}
