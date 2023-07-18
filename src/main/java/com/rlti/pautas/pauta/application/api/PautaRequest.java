package com.rlti.pautas.pauta.application.api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PautaRequest(
        @NotBlank(message = "Descrição obrigatória!")
        String descricao,
        @NotNull(message = "Horário obrigatório!")
        LocalDateTime horarioInicio,
        @Min(value = 1) @Max(value = 60)
        Integer tempo
) {
}
