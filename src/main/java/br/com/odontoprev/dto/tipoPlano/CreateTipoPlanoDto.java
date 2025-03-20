package br.com.odontoprev.dto.tipoPlano;

import br.com.odontoprev.entities.AplicacaoEnum;
import br.com.odontoprev.entities.TipoBeneficiarioEnum;

public record CreateTipoPlanoDto(
        String nome,
        TipoBeneficiarioEnum tipo,
        Double preco,
        Integer carenciaDias,
        Integer validadeDias
) {
}
