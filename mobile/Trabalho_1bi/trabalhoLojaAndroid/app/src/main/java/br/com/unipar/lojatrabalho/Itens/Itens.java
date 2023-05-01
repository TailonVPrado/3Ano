package br.com.unipar.lojatrabalho.Itens;

public class Itens {

    private String nomeItem;
    private int qtItem;
    private Double vlUnit;

    public Itens() {
        this.nomeItem = nomeItem;
        this.qtItem = qtItem;
        this.vlUnit = vlUnit;
    }

    public Itens(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQtItem() {
        return qtItem;
    }

    public void setQtItem(int qtItem) {
        this.qtItem = qtItem;
    }

    public Double getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(Double vlUnit) {
        this.vlUnit = vlUnit;
    }

    @Override
    public String toString() {
        return "Itens{" +
                "nomeItem='" + nomeItem + '\'' +
                ", qtItem=" + qtItem +
                ", vlUnit=" + vlUnit +
                '}';
    }
}
