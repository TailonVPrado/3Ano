package br.unipar.trabalho2bim.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "Classe modelo para representar um paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 60)
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
    @Size(max = 11)
    @Column(length = 11, nullable = false)
    private String cpf;

    @ManyToOne
    private Endereco endereco;

    @Column
    private boolean ativo;
}
