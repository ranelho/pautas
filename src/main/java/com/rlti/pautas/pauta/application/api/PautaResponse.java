package com.rlti.pautas.pauta.application.api;

import com.rlti.pautas.pauta.domain.Pauta;

import java.time.LocalDateTime;

public record PautaResponse (
        Long idPauta, String descricao, LocalDateTime horarioInicio, LocalDateTime horarioFim
) {
    public PautaResponse(Pauta pauta) {
        this(pauta.getIdPauta(), pauta.getDescricao(), pauta.getHorarioInicio(), pauta.getHorarioFim());
    }
}
