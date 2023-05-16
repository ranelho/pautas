package com.rlti.actdigital.pauta.application.service;

import com.rlti.actdigital.pauta.application.api.PautaRequest;
import com.rlti.actdigital.pauta.application.api.PautaResponse;
import com.rlti.actdigital.pauta.application.api.VotacaoRequest;
import com.rlti.actdigital.pauta.application.api.VotacaoResponse;

public interface PautaService {
    PautaResponse createPauta(PautaRequest request);
    VotacaoResponse createVotacao(VotacaoRequest request);
}
