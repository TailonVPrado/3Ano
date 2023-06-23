package br.com.unipar.hibernateteste.tableModel;

import br.com.unipar.hibernateteste.model.usuario.Pet;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PetTableModel extends DefaultTableModel {

    public PetTableModel() {
        this.addColumn("Codigo");
        this.addColumn("Pet");
        this.addColumn("Tamanho");
        this.addColumn("Dono/Cliente");
    }

    public PetTableModel(List<Pet> listPets) {
        this();
        for (Pet c : listPets) {
            this.addRow(new String[]{
                c.getId_pet().toString(),
                c.getNome(),
                c.getTamanho().toString(),
                c.getCliente().getNome()
            });
        }
    }

    public Pet getSelectedPet(JTable table, List<Pet> pets){
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        
        Object idObj = table.getValueAt(rowIndex, 0);
        Long id = Long.valueOf(idObj.toString());
        
        for(Pet c : pets) {
            if (c.getId_pet().equals(id)) {
                return c;
            }
        }
        
        return null;
    }
    
}
