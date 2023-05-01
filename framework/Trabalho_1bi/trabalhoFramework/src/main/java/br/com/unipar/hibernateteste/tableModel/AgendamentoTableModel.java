package br.com.unipar.hibernateteste.tableModel;

import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AgendamentoTableModel extends DefaultTableModel {

    public AgendamentoTableModel() {
        this.addColumn("Codigo");
        this.addColumn("Pet");
        this.addColumn("Data/Hora");
        this.addColumn("Servicos");
    }

    public AgendamentoTableModel(List<Agendamento> listAgentdamentos) {
        this();
        for (Agendamento c : listAgentdamentos) {
            this.addRow(new String[]{
                c.getId().toString(),
                c.getPet().getNome(),
                c.getData().toString(),
                c.toStringListaServicos()
            });
        }
    }

    public Agendamento getSelectedCliente(JTable table, List<Agendamento> agendamentos){
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        
        Object idObj = table.getValueAt(rowIndex, 0);
        Long id = Long.valueOf(idObj.toString());
        
        for(Agendamento c : agendamentos) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        
        return null;
    }
    
}
