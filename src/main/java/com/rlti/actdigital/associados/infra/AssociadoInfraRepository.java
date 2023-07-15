package com.rlti.actdigital.associados.infra;

import com.rlti.actdigital.associados.application.repository.AssociadoRepository;
import com.rlti.actdigital.associados.domain.Associado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.rlti.actdigital.handler.APIException.*;
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
    public Associado findByCpf(String cpf) {
        log.info("[inicia] AssociadoInfraRepository.findByCpf");
        Optional<Associado> optionalAssociado = jpaRepository.findByCpf(cpf);
        Associado associado = optionalAssociado.orElseThrow(() -> build(BAD_REQUEST, "Associado não encontrado!"));
        log.info("[finaliza] AssociadoInfraRepository.findByCpf");
        return associado;
    }

    @Override
    public List<Associado> findAll() {
        log.info("[inicia] AssociadoInfraRepository.findAll");
        List<Associado> associados = jpaRepository.findAll();
        log.info("[finaliza] AssociadoInfraRepository.findAll");
        return associados;
    }
}