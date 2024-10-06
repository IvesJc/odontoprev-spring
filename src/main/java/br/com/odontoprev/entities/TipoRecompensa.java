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
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private Integer expiracaoDias;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private AplicacaoEnum aplicacao;

    @OneToMany(mappedBy = "tipoRecompensa")
    private List<Recompensa> recompensas;

}

