package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 200)
    private String rua;

    @NotNull
    private int numero;

    @NotNull
    @Size(max = 200)
    private String cidade;

    @NotNull
    @Size(max = 200)
    private String estado;

    @NotNull
    @Pattern(regexp = "^\\d{5}-\\d{3}$")
    private String cep;

    private String complemento;

    @OneToOne(mappedBy = "endereco")
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "rede_credenciada_id")
    private RedeCredenciada redeCredenciada;

}
