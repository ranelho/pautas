package com.rlti.actdigital.associados.application.repository;

import com.rlti.actdigital.associados.domain.Associado;

public interface AssociadoRepository {
    Associado save(Associado associado);
    Associado findByCpf(String cpf);
}
