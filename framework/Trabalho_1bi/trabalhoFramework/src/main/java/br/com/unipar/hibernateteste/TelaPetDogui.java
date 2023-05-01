package br.com.unipar.hibernateteste;

import br.com.unipar.hibernateteste.model.dao.AgendamentoDAO;
import br.com.unipar.hibernateteste.model.dao.AgendamentoServicoDAO;
import br.com.unipar.hibernateteste.model.dao.PetDAO;
import br.com.unipar.hibernateteste.model.dao.ServicoDAO;
import br.com.unipar.hibernateteste.model.dao.UsuarioDAO;
import br.com.unipar.hibernateteste.model.enums.SituacaoEnum;
import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import br.com.unipar.hibernateteste.model.usuario.AgendamentoServico;
import br.com.unipar.hibernateteste.model.usuario.Pet;
import br.com.unipar.hibernateteste.model.usuario.Servico;
import br.com.unipar.hibernateteste.model.usuario.Usuario;
import br.com.unipar.hibernateteste.table.AgendamentoTableModel;
import br.com.unipar.hibernateteste.table.ServicoTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TelaPetDogui extends javax.swing.JFrame {

    public ArrayList<Servico> listaServico = new ArrayList<>();

    ServicoTableModel servicoTableModel = new ServicoTableModel();
    AgendamentoTableModel agendamentoTableModel = new AgendamentoTableModel();

    public TelaPetDogui() {
        initComponents();
        List<Servico> lista = new ServicoDAO().findAll();
        Servico servico = new Servico();
        ServicoTableModel servicoModel = new ServicoTableModel();
        if (JTable100 != null) {
            JTable100.setModel(servicoModel);
        }
        for (int i = 0; lista.size() > i; i++) {
            servico = lista.get(i);
            servicoTableModel.addRow(servico);
        }
        
        List<Agendamento> listaAgendamento = new AgendamentoDAO().findAll();
        Agendamento agendamentoT = new Agendamento();
        AgendamentoTableModel agendamentoModel = new AgendamentoTableModel();
        if (jTableAgendamentos != null) {
            jTableAgendamentos.setModel(agendamentoModel);
        }
        for (int i = 0; listaAgendamento.size() > i; i++) {
            agendamentoT = listaAgendamento.get(i);
            agendamentoTableModel.addRowA(agendamentoT);
            agendamentoTableModel.addRowA(agendamentoT);
        }
        
        
        TableColumn col0 = jTableAgendamentos.getColumnModel().getColumn(0);
        TableColumn col1 = jTableAgendamentos.getColumnModel().getColumn(1);
        TableColumn col2 = jTableAgendamentos.getColumnModel().getColumn(2);
        TableColumn col3 = jTableAgendamentos.getColumnModel().getColumn(3);
        TableColumn col4 = jTableAgendamentos.getColumnModel().getColumn(4);
        TableColumn col5 = jTableAgendamentos.getColumnModel().getColumn(5);

        col0.setPreferredWidth(50);     
        col1.setPreferredWidth(50);
        col2.setPreferredWidth(50);
        col3.setPreferredWidth(50);
        col4.setPreferredWidth(50);     
        col5.setPreferredWidth(300);     
        
        btExcluir.setVisible(false);
        codAgendamento.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataAgendamento = new javax.swing.JPanel();
        situacaoAgendamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtAgendamento = new javax.swing.JTextField();
        dsObserv = new javax.swing.JTextField();
        hrAgendamento = new javax.swing.JTextField();
        valorTotal = new javax.swing.JTextField();
        btSaveAgendamento = new javax.swing.JButton();
        descPet = new javax.swing.JTextField();
        codUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codPet = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable100 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        codServico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        descServico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        valorServico = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jSeparator1 = new javax.swing.JSeparator();
        btExcluir = new javax.swing.JButton();
        codAgendamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        situacaoAgendamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDENTE ", "EM_ANDAMENTO ", "CONCLUIDO ", "NAO_COMPARECEU ", "CANCELADO" }));
        situacaoAgendamento.setToolTipText("");

        jLabel1.setText("Data:");

        jLabel2.setText("Hora");

        jLabel3.setText("Obserevação");

        jLabel4.setText("Situação:");

        jLabel5.setText("Valor Total");

        dtAgendamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dtAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dtAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtAgendamentoActionPerformed(evt);
            }
        });

        dsObserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsObservActionPerformed(evt);
            }
        });

        hrAgendamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hrAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrAgendamentoActionPerformed(evt);
            }
        });

        valorTotal.setEditable(false);
        valorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalActionPerformed(evt);
            }
        });

        btSaveAgendamento.setText("Salvar Agendamento");
        btSaveAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveAgendamentoActionPerformed(evt);
            }
        });

        descPet.setEditable(false);
        descPet.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        descPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descPetActionPerformed(evt);
            }
        });

        codUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        codUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codUsuarioFocusLost(evt);
            }
        });
        codUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Cod. Usuario");

        jLabel7.setText("Cod. Pet");

        codPet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codPet.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        codPet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPetFocusLost(evt);
            }
        });
        codPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codPetActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome");

        nomeUsuario.setEditable(false);
        nomeUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioActionPerformed(evt);
            }
        });

        jLabel9.setText("Nome:");

        JTable100.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cod Servico", "Desc Servico", "Valor Servico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTable100);

        jLabel10.setText("Cod.");

        codServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codServicoFocusLost(evt);
            }
        });
        codServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codServicoActionPerformed(evt);
            }
        });

        jLabel11.setText("Descricao");

        descServico.setEditable(false);
        descServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descServicoActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor");

        valorServico.setEditable(false);
        valorServico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btExcluir.setText("Excluir");
        btExcluir.setActionCommand("");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        codAgendamento.setText("jTextField1");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Informações do Agendamento");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Informe o Serviço");

        javax.swing.GroupLayout dataAgendamentoLayout = new javax.swing.GroupLayout(dataAgendamento);
        dataAgendamento.setLayout(dataAgendamentoLayout);
        dataAgendamentoLayout.setHorizontalGroup(
            dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                        .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel10)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataAgendamentoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(codServico, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addComponent(descServico, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valorServico))
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionar)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataAgendamentoLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataAgendamentoLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(90, 90, 90)
                                    .addComponent(jLabel2)
                                    .addGap(277, 277, 277))
                                .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                    .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(codPet, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel8)
                                                .addComponent(descPet, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(76, 76, 76)
                                                .addComponent(codAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(dsObserv)
                                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                                .addComponent(btExcluir)
                                                .addGap(154, 154, 154)
                                                .addComponent(btSaveAgendamento))))
                                    .addGap(43, 43, 43)))
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addComponent(dtAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hrAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(situacaoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))))
            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataAgendamentoLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel14)
                    .addContainerGap(920, Short.MAX_VALUE)))
        );
        dataAgendamentoLayout.setVerticalGroup(
            dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dtAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hrAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(situacaoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel6))
                                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(5, 5, 5)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(descPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dsObserv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btSaveAgendamento)
                                    .addComponent(btExcluir))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dataAgendamentoLayout.createSequentialGroup()
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdicionar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addGap(68, 68, 68))))
                    .addComponent(jSeparator1)
                    .addGroup(dataAgendamentoLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(dataAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataAgendamentoLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        getContentPane().add(dataAgendamento);

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cod agendamento", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableAgendamentos.setToolTipText("");
        jTableAgendamentos.setColumnSelectionAllowed(true);
        jTableAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtAgendamentoActionPerformed

    }//GEN-LAST:event_dtAgendamentoActionPerformed

    public Double retornaValor() {
        Double valorTotal = 0.0;
        for (int i = 0; i <= listaServico.size(); i++) {
            valorTotal += listaServico.get(i).getValor().doubleValue();
        }

        return valorTotal;
    }

    private void dsObservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsObservActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dsObservActionPerformed

    private void hrAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrAgendamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrAgendamentoActionPerformed

    private void valorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalActionPerformed

    private void btSaveAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveAgendamentoActionPerformed

        try {
            gravaAgendamento();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPetDogui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveAgendamentoActionPerformed

    private void descPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descPetActionPerformed

    private void codUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codUsuarioActionPerformed

    }//GEN-LAST:event_codUsuarioActionPerformed

    private void codPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codPetActionPerformed
    }//GEN-LAST:event_codPetActionPerformed

    private void nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioActionPerformed
    }//GEN-LAST:event_nomeUsuarioActionPerformed

    private void codServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codServicoActionPerformed
    }//GEN-LAST:event_codServicoActionPerformed

    private void descServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descServicoActionPerformed
    }//GEN-LAST:event_descServicoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Servico servico = new Servico();

        servico.setId_servico(Long.parseLong(codServico.getText()));
        servico.setDescricao(descServico.getText());
        BigDecimal bd = new BigDecimal(valorServico.getText());
        servico.setValor(bd);

        addListaServico(servico);

        codServico.setText(null);
        descServico.setText(null);
        valorServico.setText(null);

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTableAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentosMouseClicked
        Agendamento agendamento = new Agendamento();
        AgendamentoDAO agendamentoDao = new AgendamentoDAO();

        int linha = jTableAgendamentos.getSelectedRow();
        Long idAgendamento = Long.parseLong(jTableAgendamentos.getValueAt(linha, 0).toString());

        agendamento = agendamentoDao.findById(idAgendamento);

        codPet.setText(agendamento.getPet().getId_pet().toString());
        codAgendamento.setText(agendamento.getId().toString());
        descPet.setText(agendamento.getPet().getNome().toString());
        codUsuario.setText(agendamento.getUsuario().getId().toString());
        nomeUsuario.setText(agendamento.getUsuario().getNome().toString());
        dtAgendamento.setText(agendamento.getDataFormatada().toString());
        hrAgendamento.setText(agendamento.getHora().toString());
        dsObserv.setText(agendamento.getObs().toString());
        valorTotal.setText(agendamento.getValor_total().toString());

        btExcluir.setVisible(true);

    }//GEN-LAST:event_jTableAgendamentosMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        AgendamentoServicoDAO agendamentoDAO = new AgendamentoServicoDAO();
        List<AgendamentoServico> listaAgendamentoS = agendamentoDAO.findWithParam(Integer.parseInt(codAgendamento.getText()));

        for (int i = 0; i < listaAgendamentoS.size(); i++) {
            AgendamentoServico agendamentoServico = new AgendamentoServico();
            agendamentoServico = agendamentoDAO.findById(listaAgendamentoS.get(i).getId_agendamentoservico());
            new AgendamentoServicoDAO().delete(agendamentoServico);
        }

        agendamentoDAO.fechar();

        try {
            Long id = Long.parseLong(codAgendamento.getText());

            AgendamentoDAO agendamentoDao = new AgendamentoDAO();
            Agendamento agendamento = new Agendamento();
            agendamento = agendamentoDao.findById(id);

            agendamentoDao.delete(agendamento);

            agendamentoDao.fechar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        List<Agendamento> listaAgendamento = new AgendamentoDAO().findAll();
        Agendamento agendamentoT = new Agendamento();
        AgendamentoTableModel agendamentoModel = new AgendamentoTableModel();
        if (jTableAgendamentos != null) {
            jTableAgendamentos.setModel(agendamentoModel);
        }
        for (int i = 0; listaAgendamento.size() > i; i++) {
            agendamentoT = listaAgendamento.get(i);
            agendamentoTableModel.addRowA(agendamentoT);
        }

        limpaTela();
        btExcluir.setVisible(false);
    }//GEN-LAST:event_btExcluirActionPerformed

    private void codServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codServicoFocusLost
        Long id = Long.parseLong("0");
        if (!codServico.getText().equals("")){
            id = Long.parseLong(codServico.getText());
        }
        if (id > 0) {
            if (new ServicoDAO().findById(id) != null) {
                Servico servico = new ServicoDAO().findById(id);
                descServico.setText(servico.getDescricao());
                valorServico.setText(servico.getValor().toString());
            } else {
                JOptionPane.showMessageDialog(null, "Servico não encontrado");
                descServico.setText(null);
                valorServico.setText(null);
            }

        }
    }//GEN-LAST:event_codServicoFocusLost

    private void codUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codUsuarioFocusLost
        Long id = Long.parseLong("0");
        if(!codUsuario.getText().equals("")){
            id = Long.parseLong(codUsuario.getText());
        }
            
        if (id > 0) {
            if (new UsuarioDAO().findById(id) != null) {
                Usuario usuario = new UsuarioDAO().findById(id);
                nomeUsuario.setText(usuario.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontrato");
                nomeUsuario.setText(null);
            }

        }
    }//GEN-LAST:event_codUsuarioFocusLost

    private void codPetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPetFocusLost
        Long id = Long.parseLong("0");
        if(!codPet.getText().equals("")){
            id = Long.parseLong(codPet.getText());
        }
        
        if (id > 0) {
            if (new PetDAO().findById(id) != null) {
                Pet pet = new PetDAO().findById(id);
                descPet.setText(pet.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrato");
                descPet.setText(null);
            }
        }
    }//GEN-LAST:event_codPetFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPetDogui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable100;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSaveAgendamento;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JTextField codAgendamento;
    private javax.swing.JTextField codPet;
    private javax.swing.JTextField codServico;
    private javax.swing.JTextField codUsuario;
    private javax.swing.JPanel dataAgendamento;
    private javax.swing.JTextField descPet;
    private javax.swing.JTextField descServico;
    private javax.swing.JTextField dsObserv;
    private javax.swing.JTextField dtAgendamento;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField hrAgendamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTableAgendamentos;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JComboBox<String> situacaoAgendamento;
    private javax.swing.JTextField valorServico;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables

    public void addListaServico(Servico servico) {
        Double valorTot = 0.0;
        try {
            listaServico.add(servico);

            for (int i = 0; i < listaServico.size(); i++) {
                valorTot += listaServico.get(i).getValor().doubleValue();
            }

            valorTotal.setText(valorTot.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void gravaAgendamento() throws ParseException {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        int idEnum;

        data = formatoData.parse(dtAgendamento.getText());

        Agendamento agendamento = new Agendamento();
        agendamento.setData(data);
        agendamento.setHora(hrAgendamento.getText());
        agendamento.setObs(dsObserv.getText());
        agendamento.setValor_total(new BigDecimal(valorTotal.getText()));

        idEnum = situacaoAgendamento.getSelectedIndex();

        if (idEnum == 0) {
            agendamento.setSituacao(SituacaoEnum.PENDENTE);
        } else if (idEnum == 1) {
            agendamento.setSituacao(SituacaoEnum.EM_ANDAMENTO);
        } else if (idEnum == 2) {
            agendamento.setSituacao(SituacaoEnum.CONCLUIDO);
        } else if (idEnum == 3) {
            agendamento.setSituacao(SituacaoEnum.NAO_COMPARECEU);
        } else if (idEnum == 4) {
            agendamento.setSituacao(SituacaoEnum.CANCELADO);
        }

        PetDAO petDao = new PetDAO();
        agendamento.setPet(petDao.findById(Long.parseLong(codPet.getText())));

        UsuarioDAO usuarioDao = new UsuarioDAO();
        agendamento.setUsuario(usuarioDao.findById(Long.parseLong(codUsuario.getText())));

        AgendamentoDAO agendamentoDao = new AgendamentoDAO();
        agendamentoDao.save(agendamento);

        gravaAgendamentoServico(agendamento);

        agendamentoDao.fechar();

        List<Agendamento> listaAgendamento = new AgendamentoDAO().findAll();
        Agendamento agendamentoT = new Agendamento();
        AgendamentoTableModel agendamentoModel = new AgendamentoTableModel();
        if (jTableAgendamentos != null) {
            jTableAgendamentos.setModel(agendamentoModel);
        }
        for (int i = 0; listaAgendamento.size() > i; i++) {
            agendamentoT = listaAgendamento.get(i);
            agendamentoTableModel.addRowA(agendamentoT);
        }

        limpaTela();

    }

    public void gravaAgendamentoServico(Agendamento agendamento) {
        AgendamentoServicoDAO agendamentoServicoDao = new AgendamentoServicoDAO();
        for (int i = 0; i < listaServico.size(); i++) {
            AgendamentoServico agendamentoServico = new AgendamentoServico();
            agendamentoServico.setAgendamento(agendamento);
            Servico servico = new Servico();
            servico.setDescricao(listaServico.get(i).getDescricao());
            servico.setId_servico(listaServico.get(i).getId_servico());
            servico.setValor(listaServico.get(i).getValor());
            agendamentoServico.setServico(servico);
            agendamentoServico.setValor_un(servico.getValor());
            agendamentoServicoDao.save(agendamentoServico);
        }
    }

    public void limpaTela() {
        codPet.setText(null);
        descPet.setText(null);
        codUsuario.setText(null);
        nomeUsuario.setText(null);
        dtAgendamento.setText(null);
        hrAgendamento.setText(null);
        dsObserv.setText(null);
        valorTotal.setText(null);
        listaServico = null;

    }

    public String retornaEnum(int id) {
        switch (id) {
            case 1:
                return "PENDENTE";
            case 2:
                return "EM_ANDAMENTO";
            case 3:
                return "CONCLUIDO";
            case 4:
                return "NAO_COMPARECEU";
            case 5:
                return "CANCELADO";
        }
        return "PENDENTE";
    }
}
