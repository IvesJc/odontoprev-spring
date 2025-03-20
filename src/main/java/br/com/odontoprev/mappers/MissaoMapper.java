package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.missao.CreateMissaoDto;
import br.com.odontoprev.dto.missao.MissaoDto;
import br.com.odontoprev.dto.missao.UpdateMissaoDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.Missao;
import br.com.odontoprev.entities.TipoMissao;

public class MissaoMapper {

    public static MissaoDto toMissaoDto(Missao missao) {
        return new MissaoDto(
                missao.getId(),
                missao.getConcluido(),
                missao.getBeneficiario().getId(),
                missao.getExpiraEm(),
                missao.getTipoMissao().getId(),
                missao.getRecompensaRecebida()
        );
    }

    public static Missao toMissaoFromCreate(CreateMissaoDto missaoDto) {
        Missao missao = new Missao();
        missao.setConcluido(missaoDto.concluido());
        missao.setRecompensaRecebida(missaoDto.recompensaRecebida());
        missao.setExpiraEm(missaoDto.expiraEm());
        // Aqui, ao invés de atribuir a entidade, atribuímos apenas o ID
        TipoMissao tipoMissao = new TipoMissao();
        tipoMissao.setId(missaoDto.tipoMissaoId());
        missao.setTipoMissao(tipoMissao);
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setId(missaoDto.beneficiarioId());
        missao.setBeneficiario(beneficiario);
        return missao;
    }

    // Mapeamento de UpdateMissaoDto para Missao
    public static Missao toMissaoFromUpdate(UpdateMissaoDto missaoDto) {
        Missao missao = new Missao();
        missao.setConcluido(missaoDto.concluido());
        missao.setRecompensaRecebida(missaoDto.recompensaRecebida());
        missao.setExpiraEm(missaoDto.expiraEm());
        // Aqui, ao invés de atribuir a entidade, atribuímos apenas o ID
        TipoMissao tipoMissao = new TipoMissao();
        tipoMissao.setId(missaoDto.tipoMissaoId());
        missao.setTipoMissao(tipoMissao);
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setId(missaoDto.beneficiarioId());
        missao.setBeneficiario(beneficiario);
        return missao;
    }
}

