package com.rlti.pautas.associados.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Associados", description = "Associados APIs")
@Validated
@RequestMapping("/v1/associados")
public interface AssociadoApi {

    @PostMapping
    @ResponseStatus(CREATED)
    AssociadoResponse newAssociado(@Valid @RequestBody AssociadoRequest request);

    @GetMapping("/{cpf}")
    @ResponseStatus(OK)
    AssociadoResponse getAssociadoByCpf(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf);

    @PatchMapping("/status/{cpf}")
    @ResponseStatus(OK)
    AssociadoStatusResponse updateStatusAssociado(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf);

    @GetMapping("/all")
    @ResponseStatus(OK)
    Page<AssociadoResponse> getAllAssociados(Pageable pageable);

    @PutMapping("/{cpf}")
    @ResponseStatus(OK)
    AssociadoResponse updateAssociado(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf,
                                      @Valid @RequestBody AssociadoUpdateRequest request);
}