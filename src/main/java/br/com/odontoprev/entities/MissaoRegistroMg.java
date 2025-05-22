package br.com.odontoprev.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "missao-registro")
public class MissaoRegistroMg {

    @Id
    private String id;
    private MultipartFile imagem;
    private Integer beneficiarioId;
    private String nomeBeneficiario;
    private String emailBeneficiario;
    private String telefoneBeneficiario;
    private TipoBeneficiarioEnum tipoBeneficiario;
    private LocalDate dataSubmissao;
    private FrequenciaEnum frequencia;
    private boolean valido;

}
