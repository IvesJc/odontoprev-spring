package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "possui")
@NoArgsConstructor
public class Possui {

    @EmbeddedId
    private PossuiId id;

    @ManyToOne
    @MapsId("tipoPlanoOdontologicoId") // Mapeia tipoPlanoOdontologicoId na chave composta
    @JoinColumn(name = "tipo_plano_odontologico_id", referencedColumnName = "id")
    private TipoPlanoOdontologico tipoPlanoOdontologico;

    @ManyToOne
    @MapsId("tipoServicoId") // Mapeia tipoServicoId na chave composta
    @JoinColumn(name = "tipo_servico_id", referencedColumnName = "id")
    private TipoServico tipoServico;
}
