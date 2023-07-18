package com.rlti.pautas.pauta.application.repository;

import com.rlti.pautas.pauta.domain.Pauta;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
    Optional<Pauta> getByDescricaoAndHoraInicio(String descricao, LocalDateTime horarioInicio);
    Pauta getById(Long idPauta);
}
