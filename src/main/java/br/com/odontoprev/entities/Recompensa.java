package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "recompensa")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Date resgatadoEm;

    @NotNull
    private Date expiraEm;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_recompensa_id")
    private TipoRecompensa tipoRecompensa;
}

