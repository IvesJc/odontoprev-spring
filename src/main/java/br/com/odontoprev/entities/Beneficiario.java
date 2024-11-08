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


    private String nome;


    private String password;


    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    private String cpf;

    @NotNull
    @Column(nullable = false, length = 15)
    private String cns;

    private int tipo;

    @Pattern(regexp = "^(\\+55\\s ?)?(0?(\\(?\\d{2}\\)?)?\\s?\\d{4,5}-?\\d{4}$)")
    private String telefone;

    @Column(name = "data_adesao")
    private Date dataAdesao;

    private String foto;

    @Column(name = "numero_contrato")
    private String numeroContrato;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    private List<Contratado> contratos;

    @OneToMany(mappedBy = "beneficiario")
    private List<Sinistro> sinistros;

    @OneToMany(mappedBy = "beneficiario")
    private List<Missao> missoes;

    @OneToMany(mappedBy = "beneficiario")
    private List<Recompensa> recompensas;

    @OneToOne
    private TipoPlanoOdontologico tipoPlanoOdontologico;

}


