package com.rlti.actdigital.pauta.application.api;

import com.rlti.actdigital.pauta.domain.Pauta;
import com.rlti.actdigital.pauta.domain.Votacao;
import com.rlti.actdigital.pauta.domain.Voto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.rlti.actdigital.pauta.domain.Voto.*;

@Data
public class ResultadoResponse {
    private String pauta;
    private LocalDateTime dataPauta;
    private List<VotacaoResponse> votantes;
    private Integer votosSim;
    private Integer votosNao;
    private Voto vencedor;

    public ResultadoResponse(List<Votacao> votacoes, Pauta pauta) {
        this.pauta = pauta.getDescricao();
        this.dataPauta = pauta.getHorarioInicio();
        this.votantes = VotacaoResponse.converte(votacoes);
        int sim = (int) votacoes.stream()
                .filter(voto -> voto.getVoto() == SIM).count();
        int nao = votacoes.size() - sim;

        this.votosSim = sim;
        this.votosNao = nao;

        if (sim > nao) {
            this.vencedor = SIM;
        } else if (sim < nao) {
            this.vencedor = NAO;
        } else {
            this.vencedor = EMPATE;
        }
    }
}
