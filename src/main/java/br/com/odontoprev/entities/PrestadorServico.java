package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cro;
    private String especialidade;
    private int contratosAtivos;
    private double avaliacaoCliente;

    // RELAC ENDERECO
    // RELAC PLANO
    // RELAC GESTORA SINISTRO
    // RELAC REDE CREDENCIADA
}
