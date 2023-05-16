package com.rlti.actdigital.pauta.application.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PautaRequest {
    @NotBlank(message = "Descrição obrigatória!")
    private String descricao;
    private LocalDateTime horarioInicio;
    @Min(value = 1)
    Integer tempo;
}
