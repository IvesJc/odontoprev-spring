package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "recompensa")
public class Recompensa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime resgatadoEm;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime expiraEm;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id", nullable = false)
    private Beneficiario beneficiario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_recompensa_id", referencedColumnName = "id", nullable = false)
    private TipoRecompensa tipoRecompensa;
}

