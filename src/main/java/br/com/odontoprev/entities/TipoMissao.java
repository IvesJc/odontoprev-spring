package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class TipoMissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    @NotNull
    private String titulo;

    @Column(nullable = false)
    @NotNull
    private Integer duracaoPadraoDias;

    @Column(nullable = false)
    @NotNull
    private Integer recompensaPadrao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequenciaEnum frequencia;

    @OneToMany(mappedBy = "tipoMissao")
    private List<Missao> missoes;

}
