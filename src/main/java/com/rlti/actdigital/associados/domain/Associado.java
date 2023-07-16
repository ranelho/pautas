package com.rlti.actdigital.associados.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.pauta.domain.Votacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_associado")
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAssociado;
    private String fullName;
    @CPF
    @Column(unique = true, updatable = false)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dataRegistro = LocalDate.now();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "associado")
    @JsonIgnore
    private List<Votacao> votos;

    public Associado(AssociadoRequest associadoRequest) {
        this.fullName = associadoRequest.fullName().toUpperCase();
        this.cpf = associadoRequest.cpf();
        this.status = gerarStatusAleatorio();
    }

    public void newStatus() {
        this.status = gerarStatusAleatorio();
    }

    private static final Random random = new Random();

    public Status gerarStatusAleatorio() {
        List<Status> list = Arrays.asList(Status.values());
        Collections.shuffle(list, random);
        return list.get(0);
    }
}
