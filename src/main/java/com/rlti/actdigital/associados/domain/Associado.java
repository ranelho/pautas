package com.rlti.actdigital.associados.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.pauta.domain.Votacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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
    private String nome;
    @CPF
    @Column(unique = true, updatable = false)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "associado")
    @JsonIgnore
    private List<Votacao> votos;

    public Associado(AssociadoRequest associadoRequest) {
        this.nome = associadoRequest.getNome().toUpperCase();
        this.cpf = associadoRequest.getCpf();
        this.status = gerarStatusAleatorio();
    }
    /**
     * Gera um status aleatório para o associado
     * @return Status
     */
    public Status gerarStatusAleatorio() {
        Random random = new Random();
        List<Status> statuses = Arrays.asList(Status.values());
        Collections.shuffle(statuses, random);
        return statuses.get(0);
    }

    public void newStatus() {
        this.status = gerarStatusAleatorio();
    }
}
