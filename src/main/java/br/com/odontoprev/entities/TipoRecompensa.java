package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tipo_recompensa")
public class TipoRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer expiracaoDias;

    private Integer aplicacao;

    @OneToMany(mappedBy = "tipoRecompensa")
    private List<Recompensa> recompensas;

}

