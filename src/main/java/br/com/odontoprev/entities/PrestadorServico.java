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

    private String nome;

    private Integer numeroCro;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    private String numeroContrato;

    @Range(min = 1, max = 2)
    private Integer avaliacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "rede_credenciada_id")
    private RedeCredenciada redeCredenciada;

    @OneToMany(mappedBy = "prestadorServico",cascade = CascadeType.ALL)
    private List<PrestadorServicoTipoServico> tipoServicos;

    @OneToMany(mappedBy = "prestadorServico")
    private List<Sinistro> sinistros;
}
