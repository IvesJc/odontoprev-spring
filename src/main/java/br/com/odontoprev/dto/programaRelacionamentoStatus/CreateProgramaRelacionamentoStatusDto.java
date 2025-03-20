package br.com.odontoprev.dto.programaRelacionamentoStatus;

import java.time.LocalDateTime;

public record CreateProgramaRelacionamentoStatusDto(
        int qtdePontos,
        LocalDateTime dataAdesao,
        int beneficiarioId) {
}
