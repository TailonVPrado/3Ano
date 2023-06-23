package br.com.unipar.hibernateteste.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
    @Id
    @Column(name = "codigo")
    private Long id_estado;
    
    @Column(length = 120)
    private String nome;
    
    @Column(length = 2)
    private String sigla;
    
    public Long getId_estado() {
        return id_estado;
    }

    public void setId_estado(Long id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigle() {
        return sigla;
    }

    public void setSigle(String sigle) {
        this.sigla = sigle;
    }

    @Override
    public String toString() {
        return "Estado{" + "id_estado=" + id_estado + ", nome=" + nome + ", sigla=" + sigla + '}';
    }
    
}
