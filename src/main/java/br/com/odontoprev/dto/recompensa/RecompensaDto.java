package br.com.odontoprev.dto.recompensa;

import java.time.LocalDateTime;

public record RecompensaDto(
        int id,
        LocalDateTime resgatadoEm,
        LocalDateTime expiraEm,
        int beneficiarioId,
        int tipoRecompensaId
) {
}
