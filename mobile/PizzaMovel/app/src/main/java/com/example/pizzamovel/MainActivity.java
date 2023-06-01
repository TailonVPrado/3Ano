package com.example.pizzamovel;

import static utils.Globais.GRANDE;
import static utils.Globais.MEDIA;
import static utils.Globais.PEQUENA;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.SaborAdapter;
import utils.Globais;

public class MainActivity extends AppCompatActivity {
    private Spinner spSabores;
    private Integer qtSaboresSelcionados = 0;
    private ListView lvSabor;
    private RadioButton rbPeqena;
    private RadioButton rbMedia;
    private RadioButton rbGrande;
    private String tamanhoAtual = PEQUENA;
    private String saborSelecionado = "";
    private String[] vetSabores = new String[]{"Selecione  <1> Sabor","Calabresa", "Bacon", "Moda da Casa", "Genovesa", "Italiana", "Toledensse", "Paulista", "Baiana", "Salame Italiano", "Confete", "Sensação", "Sedução", "Brigadeiro"};
    private ArrayAdapter adapter;
    private TextView tvDescPedido;
    private CheckBox cbBorda;
    private CheckBox cbRefrigerante;
    private TextView tvTotPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbPeqena = findViewById(R.id.rbPeqena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);
        spSabores = findViewById(R.id.spSabores);
        lvSabor = findViewById(R.id.lvSabor);
        tvDescPedido = findViewById(R.id.tvDescPedido);
        cbBorda = findViewById(R.id.cdBorda);
        cbRefrigerante = findViewById(R.id.cdRefrigerante);
        tvTotPedido = findViewById(R.id.tvTotPedido);

        lvSabor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                saborSelecionado = (String) lvSabor.getItemAtPosition(i);
            }
        });

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetSabores);
        spSabores.setAdapter(adapter);
        spSabores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(i != 0){
                if(podeAdicionarMaisSabores()){
                    Toast.makeText(MainActivity.this, "O número máximo de sabores ja foi adicionado para este tamanho!", Toast.LENGTH_SHORT).show();
                }else{
                    if(Globais.listaSabores == null) {
                        Globais.listaSabores = new ArrayList<>();
                    }
                    Globais.listaSabores.add((String) spSabores.getItemAtPosition(i));
                    atualizaListaSabor(Globais.listaSabores);
                    qtSaboresSelcionados++;
                    Toast.makeText(MainActivity.this,"Sabor "+ (String) spSabores.getItemAtPosition(i)+" adicionado ao seu Pedido!", Toast.LENGTH_SHORT).show();
                    spSabores.setSelection(0);
                    atualizaPedido();
                }
            }
        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    });

    atualizaPedido();
    }

    public void SelecionouTamanho(View view) {
        switch (view.getId()){
            case R.id.rbPeqena:
                if(qtSaboresSelcionados>1){
                    Toast.makeText(MainActivity.this,"Não é possivel selecionar este tamanho porque. O número de sabores disponivel para este tamanho é inferior a quantidade de sabores selecionados atualmente.", Toast.LENGTH_SHORT).show();
                    if(tamanhoAtual.equals(MEDIA)){
                        rbMedia.setChecked(true);
                    }else if(tamanhoAtual.equals(GRANDE)){
                        rbGrande.setChecked(true);
                    }
                }else{
                    vetSabores[0] = "Selecione <1> Sabor";
                    adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetSabores);
                    spSabores.setAdapter(adapter);
                    tamanhoAtual = PEQUENA;
                }
                break;
            case R.id.rbMedia:
                if(qtSaboresSelcionados>2) {
                    Toast.makeText(MainActivity.this, "Não é possivel selecionar este tamanho porque. O número de sabores disponivel para este tamanho é inferior a quantidade de sabores selecionados atualmente.", Toast.LENGTH_SHORT).show();
                    rbGrande.setChecked(true);
                }else{
                    vetSabores[0] = "Selecione <2> Sabores";
                    adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetSabores);
                    spSabores.setAdapter(adapter);
                    tamanhoAtual = MEDIA;
                }
                break;
            case R.id.rbGrande:
                vetSabores[0] = "Selecione <4> Sabores";
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetSabores);
                spSabores.setAdapter(adapter);
                tamanhoAtual = GRANDE;
                break;
        }
        atualizaPedido();
    }
    private void atualizaListaSabor(ArrayList<String> lista) {
        SaborAdapter adapter = new SaborAdapter(this, lista);
        lvSabor.setAdapter(adapter);
    }

    public void btRemoverSabor(View view){
        if(!saborSelecionado.equals("")){
            Toast.makeText(MainActivity.this, "Sabor "+saborSelecionado+" removido com sucesso!", Toast.LENGTH_SHORT).show();
            Globais.listaSabores.remove(saborSelecionado);
            SaborAdapter adapter = new SaborAdapter(this, Globais.listaSabores);
            lvSabor.setAdapter(adapter);
            saborSelecionado = "";
            qtSaboresSelcionados--;
            atualizaPedido();
        }
    }
    public boolean podeAdicionarMaisSabores(){
        return ((rbPeqena.isChecked() && qtSaboresSelcionados >= 1) ||
                (rbMedia.isChecked()  && qtSaboresSelcionados >= 2)||
                (rbGrande.isChecked() && qtSaboresSelcionados >= 4));
    }

    public void selecionouComplemento(View view){
        atualizaPedido();
    }
    public void atualizaPedido(){
        String pedido = "";
        Double totPedido = 0.0;

        switch (tamanhoAtual){
            case "PEQUENA":
                totPedido+= 20.00;
                break;
            case "MEDIA":
                totPedido+= 30.00;
                break;
            case "GRANDE":
                totPedido+= 40.00;
                break;
        }
        pedido+= "Pizza "+tamanhoAtual+" com os sabores: \n";

        if(Globais.listaSabores != null){
            for (String sabor : Globais.listaSabores) {
                pedido+=" - " + sabor+"\n";
            }
        }

        if(cbBorda.isChecked() && cbRefrigerante.isChecked()){
            pedido+= "\nCom borda e refrigerante";
            totPedido += 10.00;
            totPedido += 5.00;
        }else if(cbBorda.isChecked()){
            pedido+= "\nCom borda";
            totPedido += 10.00;
        }else if(cbRefrigerante.isChecked()){
            pedido+= "\nCom Refrigerante";
            totPedido += 5.00;
        }

        tvDescPedido.setText(pedido);
        tvTotPedido.setText("Total do Pedido: R$" + formataMonetario(totPedido, 2));
    }

    public String formataMonetario(Double valorMonetario, int qtdeDecimal){
        String valor = valorMonetario.toString()+"000000000";
        valor = (valor.substring(0, valor.indexOf(".")+1+qtdeDecimal)).replace(".", ",");
        return valor;
    }

    public void onClickConfirmar (View view)  {
        if(qtSaboresSelcionados<1){
            Toast.makeText(MainActivity.this, "Para finalizar o Pedido selecione pelo menos UM sabor!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Pedido efetuado com sucesso, bom apetite!", Toast.LENGTH_SHORT).show();
            limpaTela();
        }
    }
    public void limpaTela() {
        if (Globais.listaSabores != null){
            Globais.listaSabores.removeAll(Globais.listaSabores);
            lvSabor.setAdapter(new SaborAdapter(this, Globais.listaSabores));
        }
        qtSaboresSelcionados = 0;
        tamanhoAtual = PEQUENA;
        rbPeqena.setChecked(true);
        cbBorda.setChecked(false);
        cbRefrigerante.setChecked(false);
        vetSabores[0] = "Selecione <1> Sabor";
        spSabores.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetSabores));
        atualizaPedido();
    }

    public void onClickLimpar(View view){
        limpaTela();
    }
}