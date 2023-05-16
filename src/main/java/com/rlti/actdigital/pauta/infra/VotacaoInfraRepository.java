package com.rlti.actdigital.pauta.infra;

import com.rlti.actdigital.pauta.application.repository.VotacaoRepository;
import com.rlti.actdigital.pauta.domain.Votacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VotacaoInfraRepository implements VotacaoRepository {

    private final VotacaoSpringDataJPARepository votacaoSpringDataJPARepository;

    @Override
    public Votacao salva(Votacao votacao) {
        log.info("[inicia] VotacaoInfraRepository.salva ");
        log.info("[voto] {}", votacao.getVoto());
        log.info("[associado] {}", votacao.getAssociado().getIdAssociado());
        log.info("[pauta] {}", votacao.getPauta().getIdPauta());
        votacaoSpringDataJPARepository.save(votacao);
        log.info("[finaliza] VotacaoInfraRepository.salva ");
        return votacao;
    }
}
