package br.unipar.trabalho2bim.model.dto;

import br.unipar.trabalho2bim.model.Medico;
import br.unipar.trabalho2bim.model.Paciente;
import br.unipar.trabalho2bim.model.enumModel.MotivoCancelamentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Classe para tranferencia de dados do objeto Consulta")
public class ConsultaDto {
    private Long id;
    private Paciente paciente;
    private Medico medico;
    private String dataHora;
    private String motivoCancelamento;
    private boolean ativo;
}
