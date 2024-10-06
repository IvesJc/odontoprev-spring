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
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private Double valorReais;

    @OneToMany(mappedBy = "tipoServico")
    private List<TipoPlanoOdontologico> tipoPlanos;

    @OneToMany(mappedBy = "tipoServico")
    private List<Servico> servicos;

    @ManyToMany(mappedBy = "tipoServico")
    private List<PrestadorServico> prestadorServicos;
}

