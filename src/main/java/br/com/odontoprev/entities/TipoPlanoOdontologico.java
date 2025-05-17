package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tipo_plano_odontologico")
public class TipoPlanoOdontologico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoBeneficiarioEnum tipo;

    @NotNull
    @Column(nullable = false)
    private Double preco;

    @NotNull
    @Column(nullable = false)
    private Integer carenciaDias;

    @NotNull
    @Column(nullable = false)
    private Integer validadeDias;
}

