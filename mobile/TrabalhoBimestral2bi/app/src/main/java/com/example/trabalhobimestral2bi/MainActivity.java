package com.example.trabalhobimestral2bi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

import Model.Aluno;
import Model.NotaBimestre;
import Util.Global;
import adapter.MediaAdapter;
import adapter.NotaAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText etCadastroNome;
    private EditText etCadastroRa;
    private EditText etCadastroNota;
    private ListView lvNotaNota;
    private ListView lvMediaDisciplina;
    private Spinner spCadastroMateria;
    private Spinner spCadastroBimestre;
    private Spinner spNotaAluno;
    private  Spinner spMediaDicipina;
    private ArrayAdapter adapterDiciplina;
    private ArrayAdapter adapterBimestre;
    private String[] vetorBimestre = new String[]{"","1º Bimestre","2º Bimestre","3º Bimestre","4º Bimestre"};
    private String[] vertorDisciplina = new String[]{"", "Empreendedorismo",
                                                        "Relacoes interpessoais",
                                                        "Projeto Integrador",
                                                        "Desenvolvimento Frameworks",
                                                        "Gerencia de projetos",
                                                        "Qualidade de software",
                                                        "Mobile",
                                                        "Estagio",
                                                        "Desenvolvimento Web"};
    private String materiaSelecionada = "";
    private String bimestreSelecionado = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        starter();
    }
    @SuppressLint("MissingInflatedId")
    public void starter(){
        setContentView(R.layout.activity_main);
        spCadastroMateria = findViewById(R.id.spCadastroMateria);
        spCadastroBimestre = findViewById(R.id.spCadastroBimestre);
        adapterDiciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vertorDisciplina);
        adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestre);

        spCadastroMateria.setAdapter(adapterDiciplina);
        spCadastroBimestre.setAdapter(adapterBimestre);

        etCadastroRa = findViewById(R.id.etCadastroRa);
        etCadastroNome = findViewById(R.id.etCadastroNome);
        etCadastroNota = findViewById(R.id.etCadastroNoTa);

        spCadastroMateria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                materiaSelecionada = (String) spCadastroMateria.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spCadastroBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bimestreSelecionado = (String) spCadastroBimestre.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        etCadastroRa.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(!focus && Global.alunos != null){
                    for (Aluno aluno:Global.alunos) {
                        System.out.println(aluno.getRa());
                        System.out.println(etCadastroRa.getText().toString());
                        if (aluno.getRa().equals(etCadastroRa.getText().toString())){
                            etCadastroNome.setText(aluno.getNome());
                        }
                    }
                }
            }
        });

        etCadastroNota.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        if (!Pattern.matches("[0-9]+", source)) {
                            return "";
                        }
                        return null;
                    }
                }
        });
    }

    public void onClickCadastroAdicionar(View view){
        try {
            validaCamposCadastro();
            if(Global.alunos == null)
                Global.alunos = new ArrayList<>();
            NotaBimestre notaBimestre = new NotaBimestre();
            Aluno alunoCadastrado = new Aluno();
            for(int i = 0; i < Global.alunos.size();i++){
                if(etCadastroRa.getText().toString().equals(Global.alunos.get(i).getRa())){
                    alunoCadastrado = Global.alunos.get(i);
                }
            }
            Aluno aluno = new Aluno();
            if(!alunoCadastrado.getRa().equals("")){
                Global.alunos.remove(alunoCadastrado);
                aluno = alunoCadastrado;
            }else{
                aluno.setRa(etCadastroRa.getText().toString());
                aluno.setNome(etCadastroNome.getText().toString());
            }


            notaBimestre.setNota(Integer.parseInt(etCadastroNota.getText().toString()));
            notaBimestre.setDisciplina(materiaSelecionada);
            notaBimestre.setBimestre(bimestreSelecionado);
            aluno.setNotasBimestre(notaBimestre);

            Global.alunos.add(aluno);
            Toast.makeText(MainActivity.this, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
            limpaTelaCadastro();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void limpaTelaCadastro(){
        etCadastroRa.setText("");
        etCadastroNome.setText("");
        etCadastroNota.setText("");
        spCadastroBimestre.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestre));
        spCadastroMateria.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vertorDisciplina));
    }
    public void validaCamposCadastro() throws Exception{
        if (etCadastroRa.getText().toString().trim().equals("")){
            throw new Exception("RA do aluno inválido");
        } else if (etCadastroNome.getText().toString().trim().equals("")) {
            throw new Exception("Nome do aluno inválido");
        } else if (etCadastroNota.getText().toString().trim().equals("")) {
            throw new Exception("Nota do aluno inválida");
        } else if (Double.parseDouble(etCadastroNota.getText().toString()) > 100) {
            throw new Exception("A nota nao pode ser maior que 100. Verifique.");
        } else if (Double.parseDouble(etCadastroNota.getText().toString()) < 0) {
            throw new Exception("A nota nao pode ser menor que 0. Verifique.");
        } else if (materiaSelecionada.equals("")) {
            throw new Exception("Disciplina inválida");
        } else if (bimestreSelecionado.equals("")) {
            throw new Exception("Bimestre inválido");
        }
    }

    public void onClickCadastroNota(View view){
        setContentView(R.layout.activity_nota);
        spNotaAluno = findViewById(R.id.spNotaAluno);
        String[] vetAlunos = new String[1];
        vetAlunos[0] = "Selecione um aluno";
        if(Global.alunos!=null){
            vetAlunos = new String[Global.alunos.size()+1];
            vetAlunos[0] = "Selecione um aluno";
            int index = 0;
            for(Aluno aluno: Global.alunos){
                vetAlunos[++index] = aluno.getRa() + " - " + aluno.getNome();
            }
        }
        spNotaAluno.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetAlunos));
        spNotaAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0 && Global.alunos != null ){
                    atualizaListaNota(Global.alunos, i-1);
                } else if (i == 0) {
                    limpaListaNota();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void onClickCadastroMedia(View view){
        setContentView(R.layout.activity_media);

        spMediaDicipina = findViewById(R.id.spMediaDicipina);
        spMediaDicipina.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vertorDisciplina));
        spMediaDicipina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0 && Global.alunos != null ){
                    atualizaListaMedia(Global.alunos, vertorDisciplina[i]);
                } else if (i == 0) {
                    limpaListaMedia();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        starter();
    }
    private void atualizaListaMedia(ArrayList<Aluno> alunos, String materia){
        String linha1 = "";
        String linha2 = "";
        String nota1bi = "";
        String nota2bi = "";
        String nota3bi = "";
        String nota4bi = "";
        String espacoVazio = "                                                                                ";
        ArrayList<String> alunoRaImpreco = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        boolean finalizado = false;
        if(Global.alunos != null){
            for(Aluno aluno : Global.alunos){
                for(NotaBimestre nota : aluno.getNotasBimestre()){
                    for(String ra : alunoRaImpreco){
                        if(aluno.getRa() == ra){
                            finalizado = true;
                        }
                    }
                    if (nota.getDisciplina().equals(materia)){
                        if(nota.getBimestre().equals("1º Bimestre")){
                            nota1bi = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("2º Bimestre")){
                            nota2bi = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("3º Bimestre")){
                            nota3bi = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("4º Bimestre")){
                            nota4bi = nota.getNota().toString();
                        }
                    }
                }
                Double media = (Double.parseDouble(validaVazio(nota1bi)) +
                                Double.parseDouble(validaVazio(nota2bi)) +
                                Double.parseDouble(validaVazio(nota3bi)) +
                                Double.parseDouble(validaVazio(nota4bi)))/4;

                linha1 = (aluno.getRa() + espacoVazio).substring(0, 29) + "MÉDIA: " + media;
                linha2 = (aluno.getNome() + espacoVazio).substring(0, 29)+ (media >= 60 ? "APROVADO" : "REPROVADO");
                nota1bi = "";
                nota2bi = "";
                nota3bi = "";
                nota4bi = "";
                lista.add(linha1 + "\n" + linha2);
            }
        }
        lvMediaDisciplina = findViewById(R.id.lvMediaDisciplina);
        lvMediaDisciplina.setAdapter(new MediaAdapter(this, lista));
    }
    private void atualizaListaNota(ArrayList<Aluno> alunos, int indice) {
        Aluno alunoSelecionado = alunos.get(indice);
        String linha1 = "";
        String linha2 = "";
        String nota1bi = "";
        String nota2bi = "";
        String nota3bi = "";
        String nota4bi = "";
        ArrayList<String> materiasImprecas = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        boolean finalizado = false;
        String materiaAtual = "";
        for(Aluno aluno : alunos){
            if(aluno.getRa().equals(alunoSelecionado.getRa())){
                for(NotaBimestre nota : aluno.getNotasBimestre()){
                    materiaAtual = nota.getDisciplina();
                    for(String materia : materiasImprecas){
                        if(nota.getDisciplina() == materia){
                            finalizado = true;
                        }
                    }
                    if(!finalizado){
                        for(NotaBimestre notaFinal : alunoSelecionado.getNotasBimestre()){
                            if (materiaAtual.equals(notaFinal.getDisciplina())){
                                if(notaFinal.getBimestre().equals("1º Bimestre")){
                                    nota1bi = notaFinal.getNota().toString();
                                }else if(notaFinal.getBimestre().equals("2º Bimestre")){
                                    nota2bi = notaFinal.getNota().toString();
                                }else if(notaFinal.getBimestre().equals("3º Bimestre")){
                                    nota3bi = notaFinal.getNota().toString();
                                }else if(notaFinal.getBimestre().equals("4º Bimestre")){
                                    nota4bi = notaFinal.getNota().toString();
                                }
                            }
                        }
                        linha2 = escreveLinha2Nota(nota1bi, nota2bi, nota3bi, nota4bi);
                        linha1 = escreveLinha1Nota(materiaAtual, nota1bi, nota2bi, nota3bi, nota4bi);
                        finalizado = false;
                        nota1bi = "";
                        nota2bi = "";
                        nota3bi = "";
                        nota4bi = "";
                        materiasImprecas.add(nota.getDisciplina());
                        lista.add(linha1+"\n"+linha2);
                    }
                }
            }
        }
        lvNotaNota = findViewById(R.id.lvNoTaNota);
        lvNotaNota.setAdapter(new NotaAdapter(this, lista));
    }
    public void limpaListaNota(){
        lvNotaNota = findViewById(R.id.lvNoTaNota);
        lvNotaNota.setAdapter(new NotaAdapter(this, new ArrayList<>()));
    }
    public void limpaListaMedia(){
        lvMediaDisciplina = findViewById(R.id.lvMediaDisciplina);
        lvMediaDisciplina.setAdapter(new NotaAdapter(this, new ArrayList<>()));
    }
    public String escreveLinha2Nota(String n1, String n2, String n3, String n4){
        n1 = "1ºBim:"+retornoEspaco(n1);
        n2 = " 2ºBim:"+retornoEspaco(n2);
        n3 = " 3ºBim:"+retornoEspaco(n3);
        n4 = " 4ºBim:"+retornoEspaco(n4);
        return n1 + n2 + n3 + n4;

    }
    public String escreveLinha1Nota(String materia, String n1, String n2, String n3, String n4){
        n1 = validaVazio(n1);
        n2 = validaVazio(n2);
        n3 = validaVazio(n3);
        n4 = validaVazio(n4);
        Double media = (Double.parseDouble(n1) + Double.parseDouble(n2) + Double.parseDouble(n3) + Double.parseDouble(n4)) / 4;
        materia+="                                                                                                                                                                                                                                                                                      ";
        return materia.substring(0, 28) + "MÉDIA: " + formataDecimal(media,1);
    }
    public String validaVazio(String n){
        if(n.equals("")){
            n = "0";
        }
        return n;
    }
    public String formataDecimal(Double valor, int qtdeDecimal){
        String valorFormatado = valor.toString()+"000000000";
        valorFormatado = (valorFormatado.substring(0, valorFormatado.indexOf(".")+1+qtdeDecimal)).replace(".", ",");
        return valorFormatado;
    }
    public String retornoEspaco(String n){
        switch (n.length()){
            case 1:
                n+="  ";
            case 2:
                n+=" ";
                break;
            case 0:
                n+="   ";
                break;
        }
        return n;
    }
}