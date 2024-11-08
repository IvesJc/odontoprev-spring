package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "plano_odontologico")
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataValidade;

    private Double precoCobrado;

    private Date dataFinalCarencia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_plano_odontologico_id")
    private TipoPlanoOdontologico tipoPlano;


    @ManyToOne
    @JoinColumn(name = "empresa_contratante_id")
    private EmpresaContratante empresaContratante;


    @OneToMany(mappedBy = "planoOdontologico", cascade = CascadeType.ALL)
    private List<Contratado> contratos;
}
