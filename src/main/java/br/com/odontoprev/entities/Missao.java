package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int recompensa;
    private Date tempoRestante;

    // RELAC BENEFICIARIO
}
