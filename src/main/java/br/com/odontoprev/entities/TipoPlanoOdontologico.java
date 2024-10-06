package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class TipoPlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private String tipo;

    @Column(nullable = false)
    @NotNull
    private double preco;

    @Column(nullable = false)
    @NotNull
    private int carenciaDias;

    @Column(nullable = false)
    @NotNull
    private int validadeDias;

    @OneToMany(mappedBy = "tipoPlano")
    private List<TipoServico> tipoServicos;

    @OneToMany(mappedBy = "tipoPlano")
    private List<PlanoOdontologico> planos;
}

