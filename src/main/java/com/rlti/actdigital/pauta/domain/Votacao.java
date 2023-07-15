package com.rlti.actdigital.pauta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_votacao")
    @SequenceGenerator(name = "sequence_votacao", sequenceName = "sequence_votacao")
    private Long idVoto;
    @Enumerated(EnumType.STRING)
    private Voto voto;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    @JsonIgnore
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    @JsonIgnore
    private Associado associado;

    public Votacao(VotacaoRequest request, Associado associado, Pauta pauta) {
        this.voto = Voto.valueOf(request.voto());
        this.associado = associado;
        this.pauta = pauta;
    }
}
