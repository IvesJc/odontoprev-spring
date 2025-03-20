package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.prestadorServico.CreatePrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.PrestadorServicoDto;
import br.com.odontoprev.dto.prestadorServico.UpdatePrestadorServicoDto;
import br.com.odontoprev.entities.EspecialidadeEnum;
import br.com.odontoprev.entities.PrestadorServico;

public class PrestadorServicoMapper {

    public static PrestadorServicoDto toPrestadorServicoDto(PrestadorServico prestador) {
        return new PrestadorServicoDto(
                prestador.getId(),
                prestador.getNome(),
                prestador.getNumeroCro(),
                prestador.getEspecialidade().ordinal(),  // Assumindo que EspecialidadeEnum é um enum
                prestador.getNumeroContrato(),
                prestador.getAvaliacao(),
                prestador.getRedeCredenciada().getId()  // Supondo que RedeCredenciada tenha um getId()
        );
    }

    public static PrestadorServico toPrestadorServicoFromCreate(CreatePrestadorServicoDto createDto) {
        PrestadorServico prestador = new PrestadorServico();
        prestador.setNome(createDto.nome());
        prestador.setNumeroCro(createDto.numeroCro());
        prestador.setEspecialidade(EspecialidadeEnum.values()[createDto.especialidade()]);  // A especialidade é um enum
        prestador.setNumeroContrato(createDto.numeroContrato());
        prestador.setAvaliacao(createDto.avaliacao());
        // Aqui você deve buscar a RedeCredenciada pelo ID
        // prestador.setRedeCredenciada(redeCredenciadaRepository.findById(createDto.redeCredenciadaId()).orElseThrow(...));
        return prestador;
    }

    public static PrestadorServico toPrestadorServicoFromUpdate(UpdatePrestadorServicoDto updateDto) {
        PrestadorServico prestador = new PrestadorServico();
        prestador.setNome(updateDto.nome());
        prestador.setNumeroCro(updateDto.numeroCro());
        prestador.setEspecialidade(EspecialidadeEnum.values()[updateDto.especialidade()]);
        prestador.setNumeroContrato(updateDto.numeroContrato());
        prestador.setAvaliacao(updateDto.avaliacao());
        return prestador;
    }
}
