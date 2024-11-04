package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "contratado")
@NoArgsConstructor
public class Contratado {

    @EmbeddedId
    private ContratadoId id;

    @ManyToOne
    @MapsId("beneficiarioId") // Mapeia beneficiarioId na chave composta
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id")
    private Beneficiario beneficiario;

    @ManyToOne
    @MapsId("planoOdontologicoId") // Mapeia planoOdontologicoId na chave composta
    @JoinColumn(name = "plano_odontologico_id", referencedColumnName = "id")
    private PlanoOdontologico planoOdontologico;

}
