package br.com.odontoprev.dto.tipoMissao;

import br.com.odontoprev.entities.FrequenciaEnum;

public record CreateTipoMissaoDto(
        String titulo,
        Integer duracaoPadraoDias,
        Integer recompensaPadrao,
        FrequenciaEnum frequencia
) {
}
