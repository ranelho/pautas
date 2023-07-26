package com.rlti.pautas.associados.application.repository;

import com.rlti.pautas.associados.domain.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AssociadoRepository {
    Associado save(Associado associado);
    Optional<Associado> findByCpf(String cpf);
    Page<Associado> findAll(Pageable pageable);
}
