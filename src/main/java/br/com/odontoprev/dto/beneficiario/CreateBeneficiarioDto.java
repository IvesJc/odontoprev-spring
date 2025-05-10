package br.com.odontoprev.dto.beneficiario;

import java.time.LocalDate;

public record CreateBeneficiarioDto(
        String nome,
        String email,
        String password,
        String cpf,
        int tipo,
        String telefone,
        LocalDate dataAdesao,
        String fotoUrl,
        String numeroContrato,
        Integer enderecoId,
        Integer empresaContratanteId
) {
}
