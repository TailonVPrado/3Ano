package br.unipar.pet.dogui.model;

import java.util.ArrayList;

public class Pessoa {
    
    private int id;
    private String nome;
    private String nrTelefone;
    private String email;
    private boolean ativo;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String nrTelefone, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.nrTelefone = nrTelefone;
        this.email = email;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", nrTelefone=" + nrTelefone + ", email=" + email + ", ativo=" + ativo + '}';
    }
}
