package com.rlti.actdigital.associados.application.api;

import com.rlti.actdigital.associados.domain.Associado;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "Associados", description = "Associados APIs")
@Validated
@RequestMapping("/v1/associados")
public interface AssociadoApi {

    @PostMapping
    @ResponseStatus(CREATED)
    AssociadoResponse newAssociado(@Valid @RequestBody AssociadoRequest request);

    @GetMapping("/{cpf}")
    @ResponseStatus(OK)
    AssociadoResponse getAssociadoByCpf(@PathVariable("cpf") @CPF(message = "CPF inválido") String cpf);

    @PatchMapping("/status/{cpf}")
    @ResponseStatus(OK)
    AssociadoStatusResponse updateStatusAssociado(@PathVariable("cpf") @CPF(message = "CPF inválido") String cpf);

    @GetMapping("/all")
    @ResponseStatus(OK)
    List<AssociadoResponse> getAllAssociados();
}