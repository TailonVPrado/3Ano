package br.com.unipar.hibernateteste.table;

import br.com.unipar.hibernateteste.model.dao.AgendamentoDAO;
import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AgendamentoTableModel extends AbstractTableModel{

    AgendamentoDAO agendamentoDao = new AgendamentoDAO();
    
    List<Agendamento> dados = new AgendamentoDAO().findAll();
    
    private String[] colunas = {"Cod Agendamento", "St Agendamento", "Valor Agendamento","Data", "Hora", "PET"};

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
                return dados.get(linha).getId();  
            case 1:
                return dados.get(linha).getSituacao();
            case 2:
                return dados.get(linha).getValor_total();
            case 3:
                return dados.get(linha).getDataFormatada();
            case 4:
                return dados.get(linha).getHora();
            case 5:
                return dados.get(linha).getPet().getNome();
        }
        return null;
    }    
    
    public void addRowA(Agendamento agendamento) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        agendamento.setDataFormatada(formato.format(agendamento.getData()));
        this.dados.add(agendamento);
        this.fireTableDataChanged();
    }
    
}
