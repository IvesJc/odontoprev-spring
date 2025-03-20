package br.com.odontoprev.dto.missao;

import java.time.LocalDateTime;

public record CreateMissaoDto(
        int concluido,
        int recompensaRecebida,
        LocalDateTime expiraEm,
        int tipoMissaoId,
        int beneficiarioId
) {
}
