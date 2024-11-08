package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tipo_servico")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double valorReais;

    @OneToMany(mappedBy = "tipoServico",cascade = CascadeType.ALL)
    private List<Possui> possui;

    @OneToMany(mappedBy = "tipoServico")
    private List<Servico> servicos;

    @OneToMany(mappedBy = "tipoServico",cascade = CascadeType.ALL)
    private List<PrestadorServicoTipoServico> prestadorServicos;

}

