package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
    @Size(max = 200)
    private String password;

    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    private String cpf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoBeneficiarioEnum tipo;

    @NotNull
    @Pattern(regexp = "^(\\+55\\s ?)?(0?(\\(?\\d{2}\\)?)?\\s?\\d{4,5}-?\\d{4}$)")
    private String telefone;

    @NotNull
    private Date dataAdesao;

    @Size(max = 300)
    private String fotoUrl;

    @Size(max = 50)
    private String numeroContrato;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "empresa_contratante_id")
    private EmpresaContratante empresaContratante;

    @OneToOne(mappedBy = "beneficiario")
    private ProgramaRelacionamentoStatus programaRelacionamentoStatus;

    @ManyToMany(mappedBy = "beneficiarios")
    private List<PlanoOdontologico> planos;

    @OneToMany(mappedBy = "beneficiario")
    private List<Sinistro> sinistros;

    @OneToMany(mappedBy = "beneficiario")
    private List<Missao> missoes;

    @OneToMany(mappedBy = "beneficiario")
    private List<Recompensa> recompensas;

}


