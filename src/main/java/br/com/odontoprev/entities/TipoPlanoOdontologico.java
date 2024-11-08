package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tipo_plano_odontologico")
public class TipoPlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull
    private String nome;

    @Column(nullable = false, length = 13)
    @NotNull
    private String numero;


    @Column(nullable = false)
    @NotNull
    private String tipo;

    @Column(nullable = false)
    @NotNull
    private Double preco;

    @Column(nullable = false)
    @NotNull
    private Integer carenciaDias;

    @Column(nullable = false)
    @NotNull
    private Integer validadeDias;

    @OneToMany(mappedBy = "tipoPlanoOdontologico", cascade = CascadeType.ALL    )
    private List<Possui> possui;

    @OneToMany(mappedBy = "tipoPlano")
    private List<PlanoOdontologico> planos;
}

