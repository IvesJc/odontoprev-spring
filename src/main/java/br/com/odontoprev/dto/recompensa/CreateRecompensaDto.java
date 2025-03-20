package br.com.odontoprev.dto.recompensa;

import java.time.LocalDateTime;

public record CreateRecompensaDto(
        LocalDateTime resgatadoEm,
        LocalDateTime expiraEm,
        int beneficiarioId,
        int tipoRecompensaId
) {
}
