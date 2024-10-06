package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Data
@Table
public class ProgramaRelacionamentoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @ColumnDefault("0")
    private Integer qtdePontos;

    @Column(nullable = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataAdesao;

    @OneToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Beneficiario beneficiario;
}

