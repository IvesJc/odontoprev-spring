package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class RedeCredenciada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String modalidadesAtendidas;

    // RELAC PRESTADOR
}
