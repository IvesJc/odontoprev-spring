package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tipo_missao")
@AllArgsConstructor
@NoArgsConstructor
public class TipoMissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotNull
    @Column(nullable = false)
    private Integer duracaoPadraoDias;

    @NotNull
    @Column(nullable = false)
    private Integer recompensaPadrao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequenciaEnum frequencia;
}
