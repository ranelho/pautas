package com.rlti.actdigital.pauta.infra;

import com.rlti.actdigital.handler.APIException;
import com.rlti.actdigital.pauta.application.repository.PautaRepository;
import com.rlti.actdigital.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PautaInfraRepository implements PautaRepository {
    private final PautaSpringDataJPARepository pautaSpringDataJPARepository;

    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[inicio] PautaInfraRepository.salva");
        try {
            log.info("[finaliza] PautaInfraRepository.salva");
            return pautaSpringDataJPARepository.save(pauta);
        }catch (Exception e){
            log.error("[erro] PautaInfraRepository.salva", e);
            throw APIException.build(HttpStatus.BAD_REQUEST,"Associado já cadastrado");
        }
    }

    @Override
    public Optional<Pauta> getByDescricaoAndHoraInicio(String descricao, LocalDateTime horarioInicio) {
        log.info("[inicio] PautaInfraRepository.getByDescricaoAndHoraInicio");
        Optional<Pauta> pauta = pautaSpringDataJPARepository.findByDescricaoAndHorarioInicio(descricao, horarioInicio);
        log.info("[finaliza] PautaInfraRepository.getByDescricaoAndHoraInicio");
        return pauta;
    }

    @Override
    public Pauta getById(Long idPauta) {
        log.info("[inicia] PautaInfraRepository.getById");
        Optional<Pauta> optionalPauta = pautaSpringDataJPARepository.findById(idPauta);
        Pauta pauta = optionalPauta
                .orElseThrow(() ->APIException.build(HttpStatus.BAD_REQUEST, "Pauta não encontrada!"));
        return pauta;
    }
}
