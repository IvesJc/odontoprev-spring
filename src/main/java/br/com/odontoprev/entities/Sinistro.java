package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "sinistro")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataSolicitacao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataAutorizacao;

    private Double valorPagoParaPrestador;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id", nullable = false)
    private Beneficiario beneficiario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "prestador_servico_id", referencedColumnName = "id", nullable = false)
    private PrestadorServico prestadorServico;
}
