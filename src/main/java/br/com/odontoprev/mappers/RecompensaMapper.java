package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.recompensa.CreateRecompensaDto;
import br.com.odontoprev.dto.recompensa.RecompensaDto;
import br.com.odontoprev.dto.recompensa.UpdateRecompensaDto;
import br.com.odontoprev.entities.Recompensa;

public class RecompensaMapper {

    public static RecompensaDto toRecompensaDto(Recompensa recompensa) {
        return new RecompensaDto(
                recompensa.getId(),
                recompensa.getResgatadoEm(),
                recompensa.getExpiraEm(),
                recompensa.getBeneficiario().getId(), // Supondo que Beneficiario tenha um getId()
                recompensa.getTipoRecompensa().getId() // Supondo que TipoRecompensa tenha um getId()
        );
    }

    public static Recompensa toRecompensaFromCreate(CreateRecompensaDto createDto) {
        Recompensa recompensa = new Recompensa();
        recompensa.setResgatadoEm(createDto.resgatadoEm());
        recompensa.setExpiraEm(createDto.expiraEm());

        return recompensa;
    }

    public static Recompensa toRecompensaFromUpdate(UpdateRecompensaDto updateDto) {
        Recompensa recompensa = new Recompensa();
        recompensa.setResgatadoEm(updateDto.resgatadoEm());
        recompensa.setExpiraEm(updateDto.expiraEm());
        return recompensa;
    }
}
