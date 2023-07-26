package com.rlti.pautas.pauta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.pautas.pauta.application.api.PautaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_pauta")
    @SequenceGenerator(name = "sequence_pauta", sequenceName = "sequence_pauta")
    private Long idPauta;
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime horarioInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime horarioFim;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pauta")
    @JsonIgnore
    private List<Votacao> votos;

    public Pauta(PautaRequest request) {
        this.descricao = request.descricao().toUpperCase();
        this.horarioInicio = request.horarioInicio();
        if(request.tempo() > 1) {
            this.horarioFim = request.horarioInicio().plusMinutes(request.tempo());
        }
        else {
            this.horarioFim = request.horarioInicio().plusMinutes(1);
        }
    }

    public void update(PautaRequest request) {
        this.descricao = request.descricao().toUpperCase();
        this.horarioInicio = request.horarioInicio();
        if(request.tempo() > 1) {
            this.horarioFim = request.horarioInicio().plusMinutes(request.tempo());
        }
        else {
            this.horarioFim = request.horarioInicio().plusMinutes(1);
        }
    }
}
