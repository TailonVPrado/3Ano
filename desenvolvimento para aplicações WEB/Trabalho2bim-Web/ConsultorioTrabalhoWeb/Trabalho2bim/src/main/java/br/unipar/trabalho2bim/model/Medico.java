package br.unipar.trabalho2bim.model;

import br.unipar.trabalho2bim.model.enumModel.EspecialidadeEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Classe modelo para representar um médico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 60, nullable = false)
    private String email;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 15)
    @Column(length = 15, nullable = false)
    private String telefone;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 13)
    @Column(length = 13, nullable = false)
    private String crm;

    @Column
    private boolean ativo;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade = null;

    @ManyToOne
    private Endereco endereco;
}
