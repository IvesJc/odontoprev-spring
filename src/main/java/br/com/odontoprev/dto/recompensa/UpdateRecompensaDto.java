package br.com.odontoprev.dto.recompensa;

import java.time.LocalDateTime;

public record UpdateRecompensaDto(
        LocalDateTime resgatadoEm,
        LocalDateTime expiraEm,
        int beneficiarioId,
        int tipoRecompensaId
) {
}
