package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "sinistro")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataSolicitacao;

    private Date dataAutorizacao;

    private Double valorPagoParaPrestador;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Beneficiario beneficiario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "prestador_servico_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PrestadorServico prestadorServico;

    @OneToMany(mappedBy = "sinistro")
    private List<Servico> servicos;
}
