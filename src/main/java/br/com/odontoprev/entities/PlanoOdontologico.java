package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Date dataExpiracao;

    @NotNull
    private Double precoCobrado;

    private Date dataFinalCarencia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_plano_id")
    private TipoPlanoOdontologico tipoPlano;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_contratante_id")
    private EmpresaContratante empresaContratante;

    @ManyToMany(mappedBy = "planos")
    @JoinColumn(name = "beneficiario_plano")
    private List<Beneficiario> beneficiarios;
}
