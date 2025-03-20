package br.com.odontoprev.dto.prestadorServico;

public record CreatePrestadorServicoDto(
        String nome,
        int numeroCro,
        int especialidade,
        String numeroContrato,
        Integer avaliacao,
        int redeCredenciadaId
) {
}
