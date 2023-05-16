package com.rlti.actdigital.pauta.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pauta e Votação", description = "Pautas APIs")
@Validated
@RequestMapping("/v1/pautas")
public interface PautaApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PautaResponse createPauta(@Valid @RequestBody PautaRequest request);

    @PostMapping("/votacao")
    @ResponseStatus(HttpStatus.CREATED)
    public VotacaoResponse createVotacao(@Valid @RequestBody VotacaoRequest request);

    @GetMapping("/resultado/{idPauta}")
    @ResponseStatus(HttpStatus.OK)
    public ResultadoResponse getResultado(@PathVariable("idPauta") Long idPauta);
}
