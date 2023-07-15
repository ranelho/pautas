package com.rlti.actdigital.associados.application.repository;

import com.rlti.actdigital.associados.domain.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AssociadoRepository {
    Associado save(Associado associado);
    Associado findByCpf(String cpf);
    List<Associado> findAll();
}
