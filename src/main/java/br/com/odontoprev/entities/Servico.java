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

    private Double valorPago;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_servico_id", updatable = false)
    private TipoServico tipoServico;

    @ManyToOne
    @JoinColumn(name = "sinistro_id", updatable = false)
    private Sinistro sinistro;

}

