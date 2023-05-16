package com.rlti.actdigital.pauta.application.service;

import com.rlti.actdigital.pauta.application.api.*;

public interface PautaService {
    PautaResponse createPauta(PautaRequest request);
    VotacaoResponse createVotacao(VotacaoRequest request);
    ResultadoResponse getResultado(Long idPauta);
}
