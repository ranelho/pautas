package com.rlti.actdigital.associados.infra;

import com.rlti.actdigital.associados.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssociadoSprigDataJPARepository  extends JpaRepository<Associado, UUID> {
    Optional<Associado> findByCpf(String cpf);
}
