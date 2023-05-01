package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.TipoTelefoneEnum;
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
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_telefone;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(length = 120)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipo;

    public Telefone(Cliente cliente, String telefone, TipoTelefoneEnum tipo) {
        this.cliente = cliente;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public Telefone() {
    }

    public Long getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(Long id_telefone) {
        this.id_telefone = id_telefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefoneEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefoneEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Telefone{" + "id_telefone=" + id_telefone + ", cliente=" + cliente + ", telefone=" + telefone + ", tipo=" + tipo + '}';
    }

}
