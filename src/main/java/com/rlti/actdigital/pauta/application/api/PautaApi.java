package com.rlti.actdigital.pauta.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Pauta e Votação", description = "Pautas APIs")
@Validated
@RequestMapping("/v1/pautas")
public interface PautaApi {

    @PostMapping
    @ResponseStatus(CREATED)
    public PautaResponse createPauta(@Valid @RequestBody PautaRequest request);

    @PostMapping("/votacao")
    @ResponseStatus(CREATED)
    public VotacaoResponse createVotacao(@Valid @RequestBody VotacaoRequest request);

    @GetMapping("/resultado/{idPauta}")
    @ResponseStatus(OK)
    public ResultadoResponse getResultado(@PathVariable("idPauta") Long idPauta);

    @GetMapping("/{idPauta}")
    @ResponseStatus(OK)
    public PautaResponse getPauta(@PathVariable("idPauta") Long idPauta);
}
