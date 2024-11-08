package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "empresa_contratante")
@Data
public class EmpresaContratante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String nome;

    
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")
    private String cnpj;

    
    private int numeroContrato;

    @OneToMany(mappedBy = "empresaContratante")
    private List<PlanoOdontologico> planos;


}
