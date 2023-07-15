package com.rlti.actdigital.pauta.application.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PautaRequest(
        @NotBlank(message = "Descrição obrigatória!")
        String descricao,
        @NotBlank(message = "Horário obrigatório!")
        LocalDateTime horarioInicio,
        @NotBlank(message = "Tempo da Sessão obrigatória!")
        @Min(value = 1)
        Integer tempo
) {
}
