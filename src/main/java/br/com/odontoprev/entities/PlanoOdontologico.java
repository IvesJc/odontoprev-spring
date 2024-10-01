package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String tipo;
    private double preco;
    private Date dataValidade;

    // RELAC BENEFICIARIO
    // RELAC PRESTADOR SERVICO
}
