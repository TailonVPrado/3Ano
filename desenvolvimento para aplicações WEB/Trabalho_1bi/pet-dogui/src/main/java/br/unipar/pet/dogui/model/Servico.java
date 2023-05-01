package br.unipar.pet.dogui.model;

public class Servico {
    
    private int id;
    private String descricao;
    private double valor;
    private boolean status;

    public Servico() {
    }

    public Servico(int id, String descricao, double valor, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", status=" + status + '}';
    }
    
}
