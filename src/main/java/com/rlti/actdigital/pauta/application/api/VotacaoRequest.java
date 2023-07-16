package com.rlti.actdigital.pauta.application.api;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record VotacaoRequest (
        Long idPauta,
        @CPF(message = "CPF inválido")
        @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
        String cpf,
        @Pattern(regexp = "^(SIM|NAO)$", message = "Voto inválido. Valores permitidos: SIM ou NAO")
        String voto
) {
}
