package com.rlti.actdigital.associados.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Associado", description = "Associado APIs")
@RequestMapping("/v1/associado")
public interface AssociadoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AssociadoResponse newAssociado(@Valid @RequestBody AssociadoRequest associadoRequest);
}
