package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.domain.Associado;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class AssociadoRequest {
    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @NotBlank(message = "CPF obrigatório")
    @CPF(message = "CPF inválido")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    private String cpf;
}
