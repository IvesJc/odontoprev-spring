package br.com.odontoprev.dto.tipoPlano;

import br.com.odontoprev.entities.AplicacaoEnum;
import br.com.odontoprev.entities.TipoBeneficiarioEnum;
import io.micrometer.common.lang.NonNull;

public record TipoPlanoDto(
        int id,
        String nome,
        TipoBeneficiarioEnum tipo,
        Double preco,
        Integer carenciaDias,
        Integer validadeDias
) {
}
