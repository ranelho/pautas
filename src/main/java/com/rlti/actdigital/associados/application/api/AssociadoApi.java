package com.rlti.actdigital.associados.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Associados", description = "Associados APIs")
@Validated
@RequestMapping("/v1/associados")
public interface AssociadoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AssociadoResponse newAssociado(@Valid @RequestBody AssociadoRequest associadoRequest);

    @GetMapping("/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    AssociadoResponse getAssociadoByCpf(@PathVariable("cpf") @CPF(message = "CPF inválido") String cpf);

    @PatchMapping("/status/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    AssociadoStatusResponse updateStatusAssociado(@PathVariable("cpf") @CPF(message = "CPF inválido") String cpf);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<AssociadoResponse> getAllAssociados();
}
