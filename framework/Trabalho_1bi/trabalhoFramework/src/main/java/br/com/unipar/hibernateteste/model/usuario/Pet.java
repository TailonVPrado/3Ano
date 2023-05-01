package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.GeneroEnum;
import br.com.unipar.hibernateteste.model.enums.TamanhoEnum;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id_pet;

    @Column(length = 120)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TamanhoEnum tamanho;

    @Enumerated(EnumType.STRING)
    private GeneroEnum sexo;

    @Column(length = 120)
    private String obs;

    public Pet(String nome, Cliente cliente, TamanhoEnum tamanho, GeneroEnum sexo, String obs) {
        this.nome = nome;
        this.cliente = cliente;
        this.tamanho = tamanho;
        this.sexo = sexo;
        this.obs = obs;
    }

    public Pet() {
    }

    public Long getId_pet() {
        return id_pet;
    }

    public void setId_pet(Long id_pet) {
        this.id_pet = id_pet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TamanhoEnum getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoEnum tamanho) {
        this.tamanho = tamanho;
    }

    public GeneroEnum getSexo() {
        return sexo;
    }

    public void setSexo(GeneroEnum sexo) {
        this.sexo = sexo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Pet{" + "id_pet=" + id_pet + ", nome=" + nome + ", cliente=" + cliente + ", tamanho=" + tamanho + ", sexo=" + sexo + ", obs=" + obs + '}';
    }

}
