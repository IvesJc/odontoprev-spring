package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    private Double valorPago;

    @Column(nullable = false)
    @NotNull
    private Integer tipoServicoId;

    @Column(nullable = false)
    @NotNull
    private Integer sinistroId;

    @ManyToOne
    @JoinColumn(name = "tipo_servico_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoServico tipoServico;

    @ManyToOne
    @JoinColumn(name = "sinistro_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Sinistro sinistro;

}
