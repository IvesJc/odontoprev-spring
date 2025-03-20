package br.com.odontoprev.dto.missao;

import br.com.odontoprev.entities.Missao;

import java.time.LocalDateTime;

public record MissaoDto(
        Integer id,
        Integer concluido,
        Integer recompensaRecebida,
        LocalDateTime expiraEm,
        Integer tipoMissaoId,
        Integer beneficiarioId
) {
    public static MissaoDto fromEntity(Missao missao) {
        return new MissaoDto(
                missao.getId(),
                missao.getConcluido(),
                missao.getRecompensaRecebida(),
                missao.getExpiraEm(),
                missao.getTipoMissao().getId(), // Apenas o ID
                missao.getBeneficiario().getId() // Apenas o ID
        );
    }
}

