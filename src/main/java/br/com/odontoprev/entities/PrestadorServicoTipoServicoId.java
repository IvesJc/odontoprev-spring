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
public class PrestadorServicoTipoServicoId implements Serializable {

    private Integer prestadorServicoId;
    private Integer tipoServicoId;
}
