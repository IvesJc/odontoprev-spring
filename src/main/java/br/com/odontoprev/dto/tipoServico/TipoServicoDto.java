package br.com.odontoprev.dto.tipoServico;

import io.micrometer.common.lang.NonNull;

public record TipoServicoDto(
        int id,
        @NonNull String nome,
        @NonNull double valorReais
) {
}
