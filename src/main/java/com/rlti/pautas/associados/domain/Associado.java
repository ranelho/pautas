package com.rlti.pautas.associados.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.pautas.associados.application.api.AssociadoRequest;
import com.rlti.pautas.associados.application.api.AssociadoUpdateRequest;
import com.rlti.pautas.pauta.domain.Votacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_associado")
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDate dataRegistro;
    @LastModifiedDate
    private LocalDate dataAtualizacao;

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

    public void update(AssociadoUpdateRequest request) {
        this.fullName = request.fullName().toUpperCase();
    }

    private static final Random random = new Random();

    public Status gerarStatusAleatorio() {
        List<Status> list = Arrays.asList(Status.values());
        Collections.shuffle(list, random);
        return list.get(0);
    }
}
