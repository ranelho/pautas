package com.rlti.pautas.associados.application.repository;

import com.rlti.pautas.associados.domain.Associado;

import java.util.List;

public interface AssociadoRepository {
    Associado save(Associado associado);
    Associado findByCpf(String cpf);
    List<Associado> findAll();
}
