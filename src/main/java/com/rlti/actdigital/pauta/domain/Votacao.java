package com.rlti.actdigital.pauta.domain;

import com.rlti.actdigital.associados.domain.Associado;
import com.rlti.actdigital.pauta.application.api.VotacaoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_votacao")
public class Votacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVoto;
    @Enumerated(EnumType.STRING)
    private Voto voto;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    public Votacao(VotacaoRequest request, Associado associado, Pauta pauta) {
        this.voto = Voto.valueOf(request.getVoto());
        this.associado = associado;
        this.pauta = pauta;
    }
}
