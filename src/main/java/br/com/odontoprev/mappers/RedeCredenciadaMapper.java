package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.redeCredenciada.CreateRedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.RedeCredenciadaDto;
import br.com.odontoprev.dto.redeCredenciada.UpdateRedeCredenciadaDto;
import br.com.odontoprev.entities.RedeCredenciada;

public class RedeCredenciadaMapper {

    public static RedeCredenciadaDto toRedeCredenciadaDto(RedeCredenciada redeCredenciada) {
        return new RedeCredenciadaDto(
                redeCredenciada.getId(),
                redeCredenciada.getNome()
        );
    }

    public static RedeCredenciada toRedeCredenciadaFromCreate(CreateRedeCredenciadaDto createDto) {
        RedeCredenciada redeCredenciada = new RedeCredenciada();
        redeCredenciada.setNome(createDto.nome());
        return redeCredenciada;
    }
    public static RedeCredenciada toRedeCredenciadaFromUpdate(UpdateRedeCredenciadaDto createDto) {
        RedeCredenciada redeCredenciada = new RedeCredenciada();
        redeCredenciada.setNome(createDto.nome());
        return redeCredenciada;
    }
}
