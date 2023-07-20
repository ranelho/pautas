package com.rlti.pautas.associados.infra;

import com.rlti.pautas.associados.application.repository.AssociadoRepository;
import com.rlti.pautas.associados.domain.Associado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.rlti.pautas.handler.APIException.*;
import static org.springframework.http.HttpStatus.*;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AssociadoInfraRepository implements AssociadoRepository {
    private final AssociadoSprigDataJPARepository jpaRepository;

    @Override
    public Associado save(Associado associado) {
        log.info("[inicia] AssociadoInfraRepository.save");
        try {
            jpaRepository.save(associado);
            log.info("[finaliza] AssociadoInfraRepository.save");
            return associado;
        }catch (DataIntegrityViolationException e) {
            throw build(BAD_REQUEST,"Associado já cadastrado, id: " + associado.getIdAssociado());
        }
    }

    @Override
    public Optional<Associado> findByCpf(String cpf) {
        log.info("[inicia] AssociadoInfraRepository.findByCpf");
        Optional<Associado> optionalAssociado = jpaRepository.findByCpf(cpf);
        log.info("[finaliza] AssociadoInfraRepository.findByCpf");
        return optionalAssociado;
    }

    @Override
    public Page<Associado> findAll(Pageable pageable) {
        log.info("[inicia] AssociadoInfraRepository.findAll");
        Page<Associado> associados = jpaRepository.findAll(pageable);
        log.info("[finaliza] AssociadoInfraRepository.findAll");
        return associados;
    }
}