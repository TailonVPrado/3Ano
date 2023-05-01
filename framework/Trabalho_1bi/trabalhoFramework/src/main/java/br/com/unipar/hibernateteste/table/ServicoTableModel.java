package br.com.unipar.hibernateteste.table;

import br.com.unipar.hibernateteste.model.dao.ServicoDAO;
import br.com.unipar.hibernateteste.model.usuario.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ServicoTableModel extends AbstractTableModel{

    ServicoDAO servicoDAO = new ServicoDAO();
    
    List<Servico> dados = new ServicoDAO().findAll();
    
    private String[] colunas = {"Cod Servicor", "Desc Servico", "Valor Servico"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId_servico();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getValor();
        }
        return null;
    }    
    
    public void addRow(Servico servico) {
        this.dados.add(servico);
        this.fireTableDataChanged();
    }
    
    public void addRowA(Servico servico) {
        this.dados.add(servico);
        this.fireTableDataChanged();
    }
}
