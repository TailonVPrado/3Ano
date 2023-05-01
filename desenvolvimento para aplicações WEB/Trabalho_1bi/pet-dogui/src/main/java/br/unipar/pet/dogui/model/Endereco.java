package br.unipar.pet.dogui.model;

public class Endereco {
    
    private int id;
    private String nomeRua;
    private String complemento;
    private String dsBairro;
    private int nrCasa;
    private String nrCep;
    private boolean stAtivo;
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(int id, String nomeRua, String complemento, String dsBairro, int nrCasa, String nrCep, boolean stAtivo, Pessoa pessoa) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.complemento = complemento;
        this.dsBairro = dsBairro;
        this.nrCasa = nrCasa;
        this.nrCep = nrCep;
        this.stAtivo = stAtivo;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public int getNrCasa() {
        return nrCasa;
    }

    public void setNrCasa(int nrCasa) {
        this.nrCasa = nrCasa;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public boolean isStAtivo() {
        return stAtivo;
    }

    public void setStAtivo(boolean stAtivo) {
        this.stAtivo = stAtivo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", nomeRua=" + nomeRua + ", complemento=" + complemento + ", dsBairro=" + dsBairro + ", nrCasa=" + nrCasa + ", nrCep=" + nrCep + ", stAtivo=" + stAtivo + ", pessoa=" + pessoa + '}';
    }

    
}
