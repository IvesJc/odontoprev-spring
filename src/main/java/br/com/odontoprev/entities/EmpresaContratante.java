package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class EmpresaContratante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 200)
    private String nome;

    @NotNull
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")
    private String cnpj;

    @NotNull
    @Size(max = 50)
    private String numeroContrato;

    @OneToMany(mappedBy = "empresaContratante")
    private List<PlanoOdontologico> planos;

    @OneToMany(mappedBy = "empresaContratante")
    private List<Beneficiario> beneficiarios;

}
