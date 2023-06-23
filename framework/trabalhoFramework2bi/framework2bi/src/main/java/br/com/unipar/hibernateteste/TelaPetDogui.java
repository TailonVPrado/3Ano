package br.com.unipar.hibernateteste;

import br.com.unipar.hibernateteste.model.dao.AgendamentoDAO;
import br.com.unipar.hibernateteste.model.dao.AgendamentoServicoDAO;
import br.com.unipar.hibernateteste.model.dao.ServicoDAO;
import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import br.com.unipar.hibernateteste.model.usuario.AgendamentoServico;
import br.com.unipar.hibernateteste.model.usuario.Pet;
import br.com.unipar.hibernateteste.model.usuario.Servico;
import br.com.unipar.hibernateteste.model.usuario.Usuario;
import br.com.unipar.hibernateteste.model.util.PetDoguiLog;
import br.com.unipar.hibernateteste.tableModel.AgendamentoTableModel;
import br.com.unipar.hibernateteste.table.ServicoTableModel;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaPetDogui extends javax.swing.JFrame {

    public ArrayList<Servico> listaServico = new ArrayList<>();
    
    ServicoDAO daoServico;

    private Agendamento agendamento = new Agendamento();
    
    ServicoTableModel servicoTableModel = new ServicoTableModel();
    AgendamentoTableModel agendamentoTableModel = new AgendamentoTableModel();

    public TelaPetDogui() {
        initComponents();
        atualizaLista();
        atualizaServico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastro = new javax.swing.JPanel();
        jLabelPet = new javax.swing.JLabel();
        idPet = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jComboBoxServico = new javax.swing.JComboBox<>();
        jLabelServico = new javax.swing.JLabel();
        jButtonInserirServico = new javax.swing.JButton();
        jLabelHora = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();
        jScrollPaneServico = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelValorTotal = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridLayout(2, 1, 3, 0));

        jLabelPet.setText("Pet:");

        idPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPetActionPerformed(evt);
            }
        });

        jLabelData.setText("Data:");

        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        jComboBoxServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxServicoActionPerformed(evt);
            }
        });

        jLabelServico.setText("Servico:");

        jButtonInserirServico.setText("+");
        jButtonInserirServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirServicoActionPerformed(evt);
            }
        });

        jLabelHora.setText("Hora:");

        jTextFieldHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoraActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPaneServico.setViewportView(jTextArea1);

        jLabelValorTotal.setText("Valor:");

        jTextFieldValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorTotalActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Agendar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Novo Agendamento");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneServico, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelServico, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jLabelPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxServico, 0, 224, Short.MAX_VALUE)
                            .addComponent(idPet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInserirServico)))
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldValorTotal)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPet)
                    .addComponent(idPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelServico))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelHora)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonInserirServico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPaneServico, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValorTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCadastro);

        jPanelLista.setLayout(new java.awt.GridLayout(1, 0));

        jTableAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAgendamento);

        jPanelLista.add(jScrollPane1);

        getContentPane().add(jPanelLista);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPetActionPerformed

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jButtonInserirServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirServicoActionPerformed
        Servico servico = daoServico.findByDescricao(jComboBoxServico.getSelectedItem().toString());
        jTextArea1.setText(jTextArea1.getText().isEmpty() ? (servico.getDescricao()) : (jTextArea1.getText() + ", "+servico.getDescricao()));
        atualizaTotal(servico.getValor());
    }//GEN-LAST:event_jButtonInserirServicoActionPerformed

    private void jTextFieldHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoraActionPerformed

    private void jTextFieldValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorTotalActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        String data = jTextFieldData.getText();
        String hora = jTextFieldHora.getText();
        
        try{
            Date date = new SimpleDateFormat("dd/MM/yyy HH:mm").parse(data + " " + hora + ":00");
            agendamento.setDatahora(date);
            gravaAgendamento();
        }catch(Exception e){
            PetDoguiLog.infoGeral("Formatação da data e hora incorretas. Data: DD/MM/AAAA e hora: HH:MM. ERRO: " + e);
            JOptionPane.showMessageDialog(null, "Formatação da data e hora incorretas. Data: DD/MM/AAAA e hora: HH:MM" + "\nERRO: " + e);
        }
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jComboBoxServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxServicoActionPerformed

    public Double retornaValor() {
        Double valorTotal = 0.0;
        for (int i = 0; i <= listaServico.size(); i++) {
            valorTotal += listaServico.get(i).getValor().doubleValue();
        }

        return valorTotal;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPetDogui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idPet;
    private javax.swing.JButton jButtonInserirServico;
    private javax.swing.JComboBox<String> jComboBoxServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelPet;
    private javax.swing.JLabel jLabelServico;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneServico;
    private javax.swing.JTable jTableAgendamento;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldValorTotal;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    public void atualizaLista() {
        AgendamentoDAO dao = new AgendamentoDAO();
        List<Agendamento> listaAgendamentos = dao.findAll();
        AgendamentoTableModel model = new AgendamentoTableModel(listaAgendamentos);
        jTableAgendamento.setModel(model);
    }
    
    public void atualizaServico(){
        daoServico = new ServicoDAO();
        List<Servico> listaServico = daoServico.findAll();
        for (Servico servico : listaServico){
            jComboBoxServico.addItem(servico.getDescricao());
        }
        
    }
    
    public void atualizaTotal(BigDecimal valor){
        BigDecimal total  = agendamento.getValor_total();
        agendamento.setValor_total(total.add(valor));
        
        jTextFieldValorTotal.setText(agendamento.getValor_total().toString());
    }
    
    private void insereServico(Servico servico) {
        AgendamentoServico agendServ = new AgendamentoServico(agendamento,servico, servico.getValor());
        agendamento.getAgendamentoServicos().add(agendServ);
    }

    private void gravaAgendamento() {
        
        PetDoguiLog.infoGeral("GRAVANDO AGENDAMENTO");
        AgendamentoDAO dao = new AgendamentoDAO();
        Usuario usuario = new Usuario();
        usuario.setId(Long.parseLong("1"));
        agendamento.setUsuario(usuario);
        Pet pet = new Pet();
        pet.setId_pet(Long.parseLong(idPet.getText()));
        agendamento.setPet(pet);
        dao.save(agendamento);
        
        String[] vetServicos = jTextArea1.getText().split(",");
        ServicoDAO servicoDao = new ServicoDAO();
        AgendamentoServicoDAO agendamentoServicoDAO = new AgendamentoServicoDAO();
        
        for(String servicoDesc : vetServicos){
            PetDoguiLog.infoGeral("GRAVANDO SERVICOS");
            Servico servico = new Servico();
            servico = servicoDao.findByDescricao(servicoDesc);
            AgendamentoServico agendamentoServico = new AgendamentoServico();
            agendamentoServico.setAgendamento(agendamento);
            agendamentoServico.setServico(servico);
            agendamentoServico.setValor_un(new BigDecimal(jTextFieldValorTotal.getText()));
            agendamentoServicoDAO.save(agendamentoServico);
        }
        atualizaLista();
        
    }
    
}
