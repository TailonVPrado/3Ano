package br.unipar.trabalho2bim.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ApiModel(description = "Classe modelo para representar um endereço")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(length = 60, nullable = false)
    private String logradouro;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(length = 10, nullable = false)
    private String numero;

    @Size(max = 200)
    @Column(length = 200)
    private String complemento;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(length = 60, nullable = false)
    private String bairro;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(length = 60, nullable = false)
    private String cidade;

    @NotBlank
    @NotEmpty
    @NotNull
    @NotBlank
    @Size(max = 2)
    @Column(length = 2, nullable = false)
    private String uf;

    @Size(max = 8)
    @Column(length = 8)
    private String cep;

}
