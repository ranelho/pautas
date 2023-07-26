package com.rlti.pautas.pauta.application.service;

import com.rlti.pautas.pauta.application.api.*;

public interface PautaService {
    PautaResponse createPauta(PautaRequest request);
    VotacaoResponse createVotacao(Long idPauta, VotacaoRequest request);
    ResultadoResponse getResultado(Long idPauta);
    PautaResponse getPauta(Long idPauta);
    PautaResponse updatePauta(Long idPauta, PautaRequest request);
}