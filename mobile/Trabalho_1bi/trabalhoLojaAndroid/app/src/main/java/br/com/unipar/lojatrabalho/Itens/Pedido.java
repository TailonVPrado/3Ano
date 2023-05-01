package br.com.unipar.lojatrabalho.Itens;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<Itens> listaItens = new ArrayList<>();
    private String nmCliente;
    private String nrCpf;
    private int id;
    private int qtdeParcelas;

    private Double vlParcela;
    private Double vlTotal;


    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    public Pedido() {
    }

    public Pedido(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public void setQtdeParcelas(int qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

    public Double getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(Double vlParcela) {
        this.vlParcela = vlParcela;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public ArrayList<Itens> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Itens> listaItens) {
        this.listaItens = listaItens;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}