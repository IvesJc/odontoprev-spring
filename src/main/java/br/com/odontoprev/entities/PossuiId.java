package br.com.odontoprev.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PossuiId implements Serializable {

    private Integer tipoPlanoOdontologicoId;
    private Integer tipoServicoId;
}
