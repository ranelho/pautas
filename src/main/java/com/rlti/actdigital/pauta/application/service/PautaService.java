package com.rlti.actdigital.pauta.application.service;

import com.rlti.actdigital.pauta.application.api.PautaRequest;
import com.rlti.actdigital.pauta.application.api.PautaResponse;

public interface PautaService {
    PautaResponse createPauta(PautaRequest request);
}
