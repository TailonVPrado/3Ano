package br.com.unipar.hibernateteste.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Cidade {

    @Id
    @Column(name = "cod_ibge")
    private Long id_cidade;
    
    @Column(length = 120)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "cod_estado")
    private Estado estado;


    public Long getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Long id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getId_estado() {
        return estado;
    }

    public void setId_estado(Estado id_estado) {
        this.estado = id_estado;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id_cidade=" + id_cidade + ", nome=" + nome + ", estado=" + estado + '}';
    }

}
