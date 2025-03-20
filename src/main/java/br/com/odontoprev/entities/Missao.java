package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "missao")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(0)
    @Max(1)
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer concluido;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer recompensaRecebida;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime expiraEm;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_missao_id", referencedColumnName = "id", nullable = false)
    private TipoMissao tipoMissao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "id", nullable = false)
    private Beneficiario beneficiario;
}
