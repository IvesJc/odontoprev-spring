package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Size(max = 200)
    @Column
    private String rua;

    @NotNull
    @Column
    private Integer numero;

    @NotNull
    @Column
    @Size(max = 200)
    private String cidade;

    @NotNull
    @Column
    @Size(max = 200)
    private String estado;

    @NotNull
    @Size(max = 10)
    @Column
    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido")
    private String cep;

    @Column
    private String complemento;

}
