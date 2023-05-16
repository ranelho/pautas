package com.rlti.actdigital.pauta.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Pautas", description = "Pautas APIs")
@Validated
@RequestMapping("/v1/pautas")
public interface PautaApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PautaResponse createPauta(@Valid @RequestBody PautaRequest request);

}
