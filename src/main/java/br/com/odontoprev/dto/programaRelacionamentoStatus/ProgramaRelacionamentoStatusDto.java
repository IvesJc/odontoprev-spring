package br.com.odontoprev.dto.programaRelacionamentoStatus;

import java.time.LocalDateTime;

public record ProgramaRelacionamentoStatusDto(int id,
                                              int qtdePontos,
                                              LocalDateTime dataAdesao,
                                              int beneficiarioId) {
}
