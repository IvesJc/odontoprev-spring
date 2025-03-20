package br.com.odontoprev.dto.programaRelacionamentoStatus;

import java.time.LocalDateTime;

public record UpdateProgramaRelacionamentoStatusDto(
        int qtdePontos,
        LocalDateTime dataAdesao,
        int beneficiarioId) {
}
