package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Date dataAdesao;
    private Date dataNascimento;
    private int pontos;
    private String foto;
    private int numeroBeneficiario;

    // RELAC ENDERECO
    // RELAC PLANO ODONTO
    // RELAC MISSAO
}

