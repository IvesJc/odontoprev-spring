package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tipo_plano_odontologico")
public class TipoPlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(nullable = false, length = 13)
    @NotNull
    private String numero;

    private String tipo;

    private Double preco;

    private Date carenciaDias;

    private Date validadeDias;

    @OneToMany(mappedBy = "tipoPlanoOdontologico", cascade = CascadeType.ALL    )
    private List<Possui> possui;

    @OneToMany(mappedBy = "tipoPlano")
    private List<PlanoOdontologico> planos;
}

