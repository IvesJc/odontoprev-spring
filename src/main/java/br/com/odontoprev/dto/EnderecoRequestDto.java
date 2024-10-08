package br.com.odontoprev.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDto(
        Integer id,
        String rua,
        int numero,
        String cidade,
        String estado,
        String cep,
        String complemento
) {
}
