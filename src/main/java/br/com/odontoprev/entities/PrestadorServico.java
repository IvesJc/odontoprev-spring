package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "prestador_servico")
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private Integer numeroCro;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EspecialidadeEnum especialidade;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String numeroContrato;

    @Min(1)
    @Max(5)
    private Integer avaliacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "rede_credenciada_id", referencedColumnName = "id", nullable = false)
    private RedeCredenciada redeCredenciada;
}
