package com.rlti.pautas.associados.application.repository;

import com.rlti.pautas.associados.domain.Associado;

import java.util.List;
import java.util.Optional;

public interface AssociadoRepository {
    Associado save(Associado associado);
    Optional<Associado> findByCpf(String cpf);
    List<Associado> findAll();
}
