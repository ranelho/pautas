package com.rlti.actdigital.associados.infra;

import com.rlti.actdigital.associados.application.repository.AssociadoRepository;
import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AssociadoInfraRepository implements AssociadoRepository {
    private final AssociadoSprigDataJPARepository associadoSprigDataJPARepository;

    @Override
    public Associado save(Associado associado) {
        log.info("[inicia] AssociadoInfraRepository.save");
        try {
            associadoSprigDataJPARepository.save(associado);
            log.info("[finaliza] AssociadoInfraRepository.save");
            return associado;
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"Associado já cadastrado, id: "
                    + associado.getIdAssociado());
        }
    }
}
