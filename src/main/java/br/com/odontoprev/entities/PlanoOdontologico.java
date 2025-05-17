package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "plano_odontologico")
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataExpiracao;

    @NotNull
    @Column(nullable = false)
    private Double precoCobrado;

    private LocalDateTime dataFinalCarencia;

    // Foreign Keys
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_plano_odontologico_id", referencedColumnName = "id", nullable = false)
    private TipoPlanoOdontologico tipoPlano;

    @ManyToOne
    @JoinColumn(name = "empresa_contratante_id", referencedColumnName = "id")
    private EmpresaContratante empresaContratante;
}
