package br.com.unipar.lojatrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.lojatrabalho.Itens.Itens;
import br.com.unipar.lojatrabalho.Itens.Pedido;

public class MainActivity extends AppCompatActivity {

    private Button btContinuar;
    private Button btCarrinho;
    private Button btVoltar;
    private Button btAvista;
    private Button btAprazo;
    private Button btConsultar;
    private Button btNovoPedido;
    private EditText edPedido;
    private EditText edNome;
    private EditText edCpf;
    private EditText edItem;
    private EditText edQuantidade;
    private EditText edVlUnit;
    private EditText edVlTotal;
    private EditText edItens;
    private EditText edQtParcela;
    private EditText edVlParcela;
    private TextView nmVlParcela;
    private TextView nmQtParcela;
    private Button btFinalizar;
    private Button btFinalizarPedido;

    private TextView edQtItensAdd;

    ArrayList<Pedido> listaPedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        menu();

    }

    private void menu() {
        btConsultar = findViewById(R.id.btConsultar);
        btNovoPedido = findViewById(R.id.btNovoPedido);
        edPedido = findViewById(R.id.edPedido);

        btNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicio();
            }
        });

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_finalizar);

                edVlTotal = findViewById(R.id.edVlTotal);
                edItens = findViewById(R.id.edItens);
                btAvista = findViewById(R.id.btAvista);
                btAprazo = findViewById(R.id.btAprazo);
                nmQtParcela = findViewById(R.id.nmQtParcela);
                nmVlParcela = findViewById(R.id.nmVlParcela);
                edVlParcela = findViewById(R.id.edVlParcela);
                edQtParcela = findViewById(R.id.edQtParcela);
                btFinalizarPedido = findViewById(R.id.btFinalizarPedido);
                btVoltar = findViewById(R.id.btVoltar);

                Pedido pedido = consultarPedido(Integer.parseInt(edPedido.getText().toString()));
                String descItens = "";
                if (!pedido.getNrCpf().equals("")) {
                    edVlTotal.setText("RS" + pedido.getVlTotal().toString());
                    edVlTotal.setEnabled(false);
                    btAprazo.setEnabled(false);
                    btAvista.setEnabled(false);
                    for (Itens item : pedido.getListaItens()) {
                        descItens = descItens + "- " + item.getNomeItem() + ";\n";
                    }
                    edItens.setText(descItens);
                    if (pedido.getQtdeParcelas() > 1) {
                        edVlParcela.setVisibility(View.VISIBLE);
                        edQtParcela.setVisibility(View.VISIBLE);
                        edQtParcela.setEnabled(false);
                        edVlParcela.setText(pedido.getQtdeParcelas() + "X R$" + pedido.getVlParcela().toString());
                        edQtParcela.setText(pedido.getQtdeParcelas() + "");
                    }
                    btFinalizarPedido.setVisibility(View.GONE);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Pedido de Venda (" + edPedido.getText().toString() + ") Não encontrado!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    setContentView(R.layout.activity_pedido);
                    menu();

                }
                btVoltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.activity_pedido);
                        limpaTela();
                    }
                });

            }
        });
    }

    private Pedido consultarPedido(int id) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return new Pedido("");
    }

    private void inicio() {
        setContentView(R.layout.activity_main);
        btContinuar = findViewById(R.id.btContinuar);
        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);

        btContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vendasItens();
            }
        });
    }

    private void vendasItens() {
        String nome = edNome.getText().toString();
        String cpf = edCpf.getText().toString();
        try {
            if (!nome.equals("") && !cpf.equals("")) {
                vendasTela();
            } else {
                if (nome.equals("")) {
                    edNome.setError("Informe o nome do cliente!");
                }
                if (cpf.equals("")) {
                    edCpf.setError("Informe o CPF do cliente!");
                }
            }
        } catch (Exception ex) {
            Log.e("ERRO", ex.getMessage());
        }
    }

    private void vendasTela() {
        setContentView(R.layout.activity_vendas);
        btCarrinho = findViewById(R.id.btCarrinho);
        edItem = findViewById(R.id.edItem);
        edQuantidade = findViewById(R.id.edQuantidade);
        edVlUnit = findViewById(R.id.edVlUnit);
        edQtItensAdd = findViewById(R.id.edQtItensAdd);
        btFinalizar = findViewById(R.id.btFinalizar);

        ArrayList<Itens> listaItens = new ArrayList<>();

        btCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarItens(listaItens);
            }
        });

        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaItens.size() != 0) {
                    finalizaCompra(listaItens);
                }
            }
        });
    }

    private void adicionarItens(ArrayList<Itens> listaItens) {
        String nmItem = edItem.getText().toString();
        String qtItem = edQuantidade.getText().toString();
        //int qtItem
        String vlUnit = edVlUnit.getText().toString();

        try {
            if (!nmItem.equals("") && !vlUnit.equals("") && !qtItem.equals("")) {

                if (Integer.parseInt(qtItem) != 0 || Double.parseDouble(vlUnit) != 0) {
                    Itens itens = new Itens();
                    itens.setNomeItem(nmItem);
                    itens.setQtItem(Integer.parseInt(qtItem));
                    itens.setVlUnit(Double.parseDouble(vlUnit));

                    listaItens.add(itens);

                    edItem.setText("");
                    edQuantidade.setText("");
                    edVlUnit.setText("");

                    atualizaCountItens(listaItens.size());
                } else {
                    if (Integer.parseInt(qtItem) == 0) {
                        edQuantidade.setError("A quantidade não pode ser zero!");
                    }

                    if (Double.parseDouble(vlUnit) == 0) {
                        edQuantidade.setError("O valor não pode ser zero!");
                    }
                }

            } else {
                if (nmItem.equals("") || nmItem == null) {
                    edItem.setError("Informe o item que deseja adicionar!");
                }

                if (vlUnit.equals("") || vlUnit == null) {
                    edVlUnit.setError("Informe o valor unitário do item para adicionar!");
                }

                if (qtItem.equals("") || qtItem == null) {
                    edQuantidade.setError("Informe a quantidade do item para adicionar!");
                }

            }
        } catch (Exception ex) {
            Log.e("ERRO", ex.getMessage());
        }

    }

    private void atualizaCountItens(int count) {
        String text = "Itens Adicionados: " + count;

        edQtItensAdd.setText(text);
    }

    @SuppressLint("MissingInflatedId")
    private void finalizaCompra(ArrayList<Itens> listaItens) {
        Double vlItens = 0.0;
        String descItens = "";

        setContentView(R.layout.activity_finalizar);

        for (int i = 0; i < listaItens.size(); i++) {
            vlItens = vlItens + (listaItens.get(i).getVlUnit() * listaItens.get(i).getQtItem());
            descItens = descItens + "- " + listaItens.get(i).getNomeItem() + ";\n";
        }

        edVlTotal = findViewById(R.id.edVlTotal);
        edItens = findViewById(R.id.edItens);
        btAvista = findViewById(R.id.btAvista);
        btAprazo = findViewById(R.id.btAprazo);
        nmQtParcela = findViewById(R.id.nmQtParcela);
        nmVlParcela = findViewById(R.id.nmVlParcela);
        edVlParcela = findViewById(R.id.edVlParcela);
        edQtParcela = findViewById(R.id.edQtParcela);
        btFinalizarPedido = findViewById(R.id.btFinalizarPedido);
        btVoltar = findViewById(R.id.btVoltar);
        edVlTotal.setText(vlItens.toString());
        edItens.setText(descItens);


        btAvista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double vlDesconto = Double.parseDouble(edVlTotal.getText().toString());
                vlDesconto = vlDesconto - (vlDesconto * 5) / 100;
                edVlTotal.setText(vlDesconto.toString());
                btAprazo.setEnabled(false);
                btAvista.setEnabled(false);
            }
        });

        btAprazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double vlDesconto = Double.parseDouble(edVlTotal.getText().toString());
                vlDesconto = vlDesconto + (vlDesconto * 5) / 100;
                edVlTotal.setText(vlDesconto.toString());
                btAvista.setEnabled(false);
                btAprazo.setEnabled(false);

                edQtParcela.setVisibility(View.VISIBLE);
                edVlParcela.setVisibility(View.VISIBLE);
                nmQtParcela.setVisibility(View.VISIBLE);
                nmVlParcela.setVisibility(View.VISIBLE);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_pedido);
                limpaTela();
            }
        });

        btFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pedido pedido = new Pedido();
                pedido.setListaItens(listaItens);
                pedido.setNrCpf(edCpf.getText().toString());
                pedido.setNmCliente(edNome.getText().toString());
                if (edQtParcela.getText().toString().equals("")) {
                    pedido.setQtdeParcelas(1);
                    pedido.setVlParcela(Double.parseDouble(edVlTotal.getText().toString()));
                } else {
                    pedido.setQtdeParcelas(Integer.parseInt(edQtParcela.getText().toString()));
                    pedido.setVlParcela(Double.parseDouble(edVlParcela.getText().toString().substring(edVlParcela.getText().toString().indexOf("$") + 1)));
                }
                pedido.setVlTotal(Double.parseDouble(edVlTotal.getText().toString()));
                pedido.setId(listaPedidos.size() + 1);
                listaPedidos.add(pedido);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Pedido de Venda (" + pedido.getId() + ") Cadastrado com Sucesso!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                setContentView(R.layout.activity_pedido);
                menu();
                limpaTela();

            }
        });

        edQtParcela.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edQtParcela.getText().toString() != null || edQtParcela.getText().toString() != "") {
                    int qtParcela = Integer.parseInt(edQtParcela.getText().toString());
                    Double vlCompra = Double.parseDouble(edVlTotal.getText().toString());

                    edVlParcela.setText(calculaValorParcela(qtParcela, vlCompra));
                }
            }
        });

    }

    public String calculaValorParcela(int qtParcela, Double valorCompra) {
        String valorParcela = qtParcela + "X R$";
        Double vlParcela;

        vlParcela = valorCompra / qtParcela;

        valorParcela += Math.ceil(vlParcela);

        return valorParcela;
    }

    public void limpaTela() {
        edCpf.setText("");
        edNome.setText("");
        edItem.setText("");
        edItens.setText("");
        edQuantidade.setText("");
        edQtItensAdd.setText("");
        edVlTotal.setText("");
        edVlUnit.setText("");
    }
}