package br.unipar.trabalho2bim.model;

import br.unipar.trabalho2bim.model.enumModel.MotivoCancelamentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "Classe modelo para representar uma consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Medico medico;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date dataHora;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private MotivoCancelamentoEnum motivoCancelamento;

    @Column
    private boolean ativo;
}
