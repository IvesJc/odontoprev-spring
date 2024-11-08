package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tipo_missao")
public class TipoMissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private Integer duracaoPadraoDias;

    private Integer recompensaPadrao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequenciaEnum frequencia;

    @OneToMany(mappedBy = "tipoMissao")
    private List<Missao> missoes;

}
