package br.com.odontoprev.dto.sinistro;

import io.micrometer.common.lang.NonNull;

import java.time.LocalDateTime;

public record CreateSinistroDto(
                                @NonNull LocalDateTime dataSolicitacao,
                                @NonNull LocalDateTime dataAutorizacao,
                                Double valorPagoParaPrestador,
                                @NonNull int beneficiarioId,
                                @NonNull int prestadorServicoId) {
}
