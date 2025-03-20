package br.com.odontoprev.dto.prestadorServico;

public record UpdatePrestadorServicoDto(
        String nome,
        int numeroCro,
        int especialidade,
        String numeroContrato,
        Integer avaliacao,
        int redeCredenciadaId
) {
}
