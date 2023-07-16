package com.rlti.actdigital.pauta.infra;

import com.rlti.actdigital.pauta.application.repository.PautaRepository;
import com.rlti.actdigital.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.rlti.actdigital.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PautaInfraRepository implements PautaRepository {
    private final PautaSpringDataJPARepository jpaRepository;

    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[inicio] PautaInfraRepository.salva");
        try {
            log.info("[finaliza] PautaInfraRepository.salva");
            return jpaRepository.save(pauta);
        }catch (Exception e){
            throw build(BAD_REQUEST,"Associado já cadastrado");
        }
    }

    @Override
    public Optional<Pauta> getByDescricaoAndHoraInicio(String descricao, LocalDateTime horarioInicio) {
        log.info("[inicio] PautaInfraRepository.getByDescricaoAndHoraInicio");
        Optional<Pauta> pauta = jpaRepository.findByDescricaoAndHorarioInicio(descricao, horarioInicio);
        log.info("[finaliza] PautaInfraRepository.getByDescricaoAndHoraInicio");
        return pauta;
    }

    @Override
    public Pauta getById(Long idPauta) {
        log.info("PautaInfraRepository.getById");
        return jpaRepository.findById(idPauta).orElseThrow(() -> build(BAD_REQUEST, "Pauta não encontrada!"));
    }
}