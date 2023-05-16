package com.rlti.actdigital.pauta.domain;

import com.rlti.actdigital.associados.domain.Associado;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVoto;
    @Enumerated(EnumType.STRING)
    private Voto voto;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    public Votacao(String voto, Associado associado, Pauta pauta) {
        this.voto = Voto.valueOf(voto);
        this.associado = associado;
        this.pauta = pauta;
    }
}
