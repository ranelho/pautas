package com.rlti.actdigital.pauta.application.api;

import com.rlti.actdigital.pauta.domain.Votacao;
import com.rlti.actdigital.pauta.domain.Voto;
import lombok.Data;

import java.util.List;

@Data
public class ResultadoResponse {
    private Integer votosSim;
    private Integer votosNao;
    private String vencedor;

    public ResultadoResponse(List<Votacao> votacoes) {
        int[] resultados = somarResultados(votacoes);
        this.votosSim = resultados[0];
        this.votosNao = resultados[1];
        //vencedor é quem tem o maior resultado
        if (this.votosSim > this.votosNao) {
            this.vencedor = "SIM";
        }else if (this.votosSim < this.votosNao){
            this.vencedor = "NAO";
        }else {
            this.vencedor = "EMPATE";
        }
    }

   //somar os votos de cada voto
    private int[] somarResultados(List<Votacao> votacoes) {
        int votosSim = 0;
        int votosNao = 0;
        for (Votacao voto : votacoes) {
            if (voto.getVoto() == Voto.SIM) {
                votosSim++;
            } else {
                votosNao++;
            }
        }
        return new int[]{votosSim, votosNao};
    }
}
