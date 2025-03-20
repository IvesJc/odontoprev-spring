package br.com.odontoprev.dto.plano;

import java.time.LocalDateTime;

public record UpdatePlanoDto(int id,
                             LocalDateTime dataExpiracao,
                             double precoCobrado,
                             LocalDateTime dataFinalCarencia,
                             int tipoPlanoId,
                             int empresaContratanteId) {
}
