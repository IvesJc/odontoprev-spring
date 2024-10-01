package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class GestoraSinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numeroSinistro;
    private Date dataSolicitacao;
    private Date dataAutorizacao;
    private String statusPagamento;

    // RELAC PRESTADOR
}
