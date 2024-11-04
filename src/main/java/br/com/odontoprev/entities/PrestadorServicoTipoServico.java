package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "prestador_servico_tipo_servico")
public class PrestadorServicoTipoServico {

    @EmbeddedId
    private PrestadorServicoTipoServicoId id;

    @ManyToOne
    @MapsId("prestadorServicoId") // Mapeia tipoPlanoOdontologicoId na chave composta
    @JoinColumn(name = "prestador_servico_id", referencedColumnName = "id")
    private PrestadorServico prestadorServico;

    @ManyToOne
    @MapsId("tipoServicoId") // Mapeia tipoServicoId na chave composta
    @JoinColumn(name = "tipo_servico_id", referencedColumnName = "id")
    private TipoServico tipoServico;

}
