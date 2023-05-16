package com.rlti.actdigital.associados.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.actdigital.associados.application.api.AssociadoRequest;
import com.rlti.actdigital.pauta.domain.Pauta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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

    @ManyToMany(mappedBy = "associados")
    @JsonIgnore
    List<Pauta> pautas;

    public Associado(AssociadoRequest associadoRequest) {
        this.nome = associadoRequest.getNome();
        this.cpf = associadoRequest.getCpf();
        this.status = gerarStatusAleatorio();
    }

    public Status gerarStatusAleatorio() {
        Random random = new Random();
        Status[] statuses = Status.values();
        int randomIndex = random.nextInt(statuses.length);
        return statuses[randomIndex];
    }
}
