package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private double valorReais;

    @OneToMany(mappedBy = "tipoServico")
    private List<TipoPlanoOdontologico> tipoPlanos;

    @OneToMany(mappedBy = "tipoServico")
    private List<Servico> servicos;

    @OneToMany(mappedBy = "tipoServico")
    private List<PrestadorServico> prestadorServicos;
}

