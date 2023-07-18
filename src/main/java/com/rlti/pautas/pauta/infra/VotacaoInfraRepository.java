package com.rlti.pautas.pauta.infra;

import com.rlti.pautas.associados.domain.Associado;
import com.rlti.pautas.handler.APIException;
import com.rlti.pautas.pauta.application.repository.VotacaoRepository;
import com.rlti.pautas.pauta.domain.Pauta;
import com.rlti.pautas.pauta.domain.Votacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VotacaoInfraRepository implements VotacaoRepository {

    private final VotacaoSpringDataJPARepository votacaoSpringDataJPARepository;

    @Override
    public Votacao salva(Votacao votacao) {
        log.info("[inicia] VotacaoInfraRepository.salva ");
        votacaoSpringDataJPARepository.save(votacao);
        log.info("[finaliza] VotacaoInfraRepository.salva ");
        return votacao;
    }

    @Override
    public Optional<Votacao> findByAssociadoAndPauta(Associado associado, Pauta pauta) {
        log.info("[inicia] VotacaoInfraRepository.findByAssociadoAndPauta ");
        Optional<Votacao> result = votacaoSpringDataJPARepository.findByAssociadoAndPauta(associado, pauta);
        log.info("[finaliza] VotacaoInfraRepository.findByAssociadoAndPauta ");
        return result;
    }

    @Override
    public List<Votacao> findByPauta(Pauta byId) {
        log.info("[inicia] VotacaoInfraRepository.findByPauta ");
        List<Votacao> result = votacaoSpringDataJPARepository.findByPauta(byId);
        log.info("[finaliza] VotacaoInfraRepository.findByPauta ");
        return result;
    }
}
