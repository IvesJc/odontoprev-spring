package br.com.odontoprev.dto.beneficiario;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BeneficiarioDto(
        int id,
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
