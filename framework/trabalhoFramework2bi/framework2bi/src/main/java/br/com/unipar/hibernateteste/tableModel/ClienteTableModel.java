package br.com.unipar.hibernateteste.tableModel;

import br.com.unipar.hibernateteste.model.usuario.Cliente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteTableModel extends DefaultTableModel{
    
    public ClienteTableModel() {
        this.addColumn("Código");
        this.addColumn("CPF");
        this.addColumn("Nome");
    }
    
    public ClienteTableModel(List<Cliente> listCliente) {
        this();
        for (Cliente c : listCliente) {
            this.addRow(new String[]{
                String.valueOf(c.getId_cliente()),
                c.getCpf().toString(),
                c.getNome().toString()
            });
        }
    }
    
    public Cliente getSelectedCliente(JTable table, List<Cliente> clientes){
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        
        Object idObj = table.getValueAt(rowIndex, 0);
        Long id = Long.valueOf(idObj.toString());
        
        for(Cliente c : clientes) {
            if(c.getId_cliente().equals(id)){
                return c;
            }
        }
        
        return null;
    }
}
