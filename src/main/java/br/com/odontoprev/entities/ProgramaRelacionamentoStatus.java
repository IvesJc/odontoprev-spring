package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "programa_relacionamento_status")
public class ProgramaRelacionamentoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer qtdePontos;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataAdesao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id", nullable = false)
    private Beneficiario beneficiario;
}

