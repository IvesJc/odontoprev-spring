package br.com.odontoprev.dto.tipoServico;

import io.micrometer.common.lang.NonNull;

public record UpdateTipoServicoDto(
        @NonNull String nome,
        @NonNull double valorReais
) {
}
