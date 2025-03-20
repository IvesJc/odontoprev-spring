package br.com.odontoprev.dto.tipoServico;

import io.micrometer.common.lang.NonNull;

public record CreateTipoServicoDto(
        @NonNull String nome,
        @NonNull double valorReais
) {
}
