package br.com.odontoprev.dto.prestadorServico;

public record PrestadorServicoDto(
        int id,
        String nome,
        int numeroCro,
        int especialidade,
        String numeroContrato,
        Integer avaliacao,
        int redeCredenciadaId
) {
}
