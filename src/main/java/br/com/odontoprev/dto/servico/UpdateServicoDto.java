package br.com.odontoprev.dto.servico;

public record UpdateServicoDto(
        double valorPago,
        int tipoServicoId,
        int sinistroId
) {
}
