package br.com.odontoprev.dto.tipoRecompensa;

import br.com.odontoprev.entities.AplicacaoEnum;

public record UpdateTipoRecompensaDto(
        String nome,
        Integer expiracaoDias,
        AplicacaoEnum aplicacao
) {
}
