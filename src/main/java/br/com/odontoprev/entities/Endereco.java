package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    // RELAC BENEFICIARIO
    // RELAC PRESTADOR SERVIÇO
}
