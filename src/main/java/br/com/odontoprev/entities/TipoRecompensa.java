package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class TipoRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private int expiracaoDias;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private AplicacaoEnum aplicacao;

    @OneToMany(mappedBy = "tipoRecompensa")
    private List<Recompensa> recompensas;

}

