package Model;

import java.util.ArrayList;

public class Aluno {
    String ra = "";
    String nome;
    ArrayList<NotaBimestre> notasBimestre = new ArrayList<>();

    public Aluno() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<NotaBimestre> getNotasBimestre() {
        return notasBimestre;
    }

    public void setNotasBimestre(NotaBimestre notasBimestre) {
        for (NotaBimestre nota:this.notasBimestre) {
            if (nota.getBimestre().equals(notasBimestre.getBimestre()) && nota.getDisciplina().equals(notasBimestre.getDisciplina())){
                this.notasBimestre.remove(nota);
            }
        }
        this.notasBimestre.add(notasBimestre);
    }
}
