package br.com.odontoprev.dto.tipoRecompensa;

import br.com.odontoprev.entities.AplicacaoEnum;

public record TipoRecompensaDto(
        Integer id,
        String nome,
        Integer expiracaoDias,
        AplicacaoEnum aplicacao
) {}
