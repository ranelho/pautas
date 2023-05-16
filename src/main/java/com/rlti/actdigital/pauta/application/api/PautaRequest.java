package com.rlti.actdigital.pauta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PautaRequest {
    @NotBlank(message = "Descrição obrigatória!")
    private String descricao;
    @NotBlank
    private LocalDateTime horarioInicio;
}
