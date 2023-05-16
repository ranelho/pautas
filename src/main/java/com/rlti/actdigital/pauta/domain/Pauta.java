package com.rlti.actdigital.pauta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.actdigital.pauta.application.api.PautaRequest;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
        this.descricao = request.getDescricao().toUpperCase();
        this.horarioInicio = request.getHorarioInicio();
        if(request.getTempo() > 1) {
            this.horarioFim = request.getHorarioInicio().plusMinutes(request.getTempo());
        }
        else {
            //tempo por default é 1 minuto
            this.horarioFim = request.getHorarioInicio().plusMinutes(1);
        }
    }
}
