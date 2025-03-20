package br.com.odontoprev.dto.endereco;

public record EnderecoDto(
        Integer id,
        String rua,
        int numero,
        String cidade,
        String estado,
        String cep,
        String complemento
) {
}
