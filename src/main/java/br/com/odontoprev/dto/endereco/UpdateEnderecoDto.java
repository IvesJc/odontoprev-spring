package br.com.odontoprev.dto.endereco;

public record UpdateEnderecoDto(
        String rua,
        int numero,
        String cidade,
        String estado,
        String cep,
        String complemento
) {
}
