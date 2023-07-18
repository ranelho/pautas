package com.rlti.pautas.associados.application.api;

import jakarta.validation.constraints.NotBlank;

public record AssociadoUpdateRequest( @NotBlank(message = "Nome obrigatório") String fullName) {
}
