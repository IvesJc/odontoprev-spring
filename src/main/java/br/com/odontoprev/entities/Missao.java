package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "missao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Range(min = 0, max = 1)
    private Integer concluido;

    private int recompensaRecebida;

    private Date expiraEm;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_missao_id")
    private TipoMissao tipoMissao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;


}
