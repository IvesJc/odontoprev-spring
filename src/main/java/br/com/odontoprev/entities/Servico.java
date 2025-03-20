package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private Double valorPago;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_servico_id", referencedColumnName = "id", nullable = false)
    private TipoServico tipoServico;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sinistro_id", referencedColumnName = "id", nullable = false)
    private Sinistro sinistro;
}

