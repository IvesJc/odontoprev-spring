package br.com.odontoprev.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "beneficiario")
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
    private String foto;

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

//    @JsonManagedReference
////    @Cascade(org.hibernate.annotations.CascadeType.ALL)
////    @ManyToMany
////    @JoinTable(
////            name = "contratado",
////            joinColumns = @JoinColumn(name = "beneficiario_id", referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(name = "plano_odontologico_id", referencedColumnName = "id")
////    )
////    private List<PlanoOdontologico> planos;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    private List<Contratado> contratos;

    @OneToMany(mappedBy = "beneficiario")
    private List<Sinistro> sinistros;

    @OneToMany(mappedBy = "beneficiario")
    private List<Missao> missoes;

    @OneToMany(mappedBy = "beneficiario")
    private List<Recompensa> recompensas;

}


