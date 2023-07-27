package com.rlti.pautas.associados.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record AssociadoRequest (
        @NotBlank(message = "Nome obrigatório")
        String fullName,
        @NotBlank(message = "CPF obrigatório") @CPF(message = "CPF inválido")
        @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
        String cpf
) {
}