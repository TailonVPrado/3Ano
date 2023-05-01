package br.unipar.pet.dogui.model;

import br.unipar.pet.dogui.model.enums.GeneroEnum;
import br.unipar.pet.dogui.model.enums.PorteEnum;

public class Pet {
    
    private int id;
    private String nome;
    private Pessoa dono;
    private GeneroEnum genero;
    private double peso;
    private PorteEnum porte;
    private boolean status;

    public Pet() {
    }

    public Pet(int id, String nome, Pessoa dono, GeneroEnum genero, double peso, PorteEnum porte, boolean status) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.genero = genero;
        this.peso = peso;
        this.porte = porte;
        this.status = status;
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

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public PorteEnum getPorte() {
        return porte;
    }

    public void setPorte(PorteEnum porte) {
        this.porte = porte;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", nome=" + nome + ", dono=" + dono + ", genero=" + genero + ", peso=" + peso + ", porte=" + porte + ", status=" + status + '}';
    }
    
}
