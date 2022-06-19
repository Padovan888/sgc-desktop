package interfaceGrafica;

import dominio.Colaborador;
import dominio.Competencia;
import dominio.Turma;
import dominio.TurmaColaboradorCompetencia;
import dominio.TurmaColaboradorCompetenciaId;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import gerenciaTarefas.Util;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogCadastroTurma extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    public DialogCadastroTurma(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        gerenciadorInterfaceGrafica = gerenciador;
        initComponents();
    }

    public void carregarComboBoxColaboradores() {
        List<Colaborador> colaboradores;
        colaboradores = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().listarColaboradores();
        for (Colaborador colaborador : colaboradores) {
            this.jComboBoxNomeColaborador.addItem(colaborador);
        }
    }

    public void carregarComboBoxCompetencias() {
        Colaborador colaborador = new Colaborador();
        colaborador = (Colaborador) this.jComboBoxNomeColaborador.getSelectedItem();
        if (colaborador != null) {
            List<Competencia> competencias = new ArrayList<>();
            for (int i = 0; i < colaborador.getCompetencias().size(); i++) {
                Competencia competencia = new Competencia();
                competencia = colaborador.getCompetencias().get(i);
                competencias.add(competencia);
            }
            for (Competencia competencia : competencias) {
                this.jComboBoxNomeCompetencia.addItem(competencia);
            }
        }
    }

    public void limparCampos() {
        this.jTextFieldNome.setText("");
        this.jTextFieldDescricao.setText("");
        this.jFormattedTextFieldDataDeInicio.setText("");
        this.jFormattedTextFieldDataDeTermino.setText("");
        this.jTextFieldCargaHoraria.setText("");
        this.jTextAreaConteudo.setText("");
        removerLinhasTabela();
    }

    public void removerLinhasTabela() {
        ((DefaultTableModel) this.jTableTabelaColaboradorCompetencia.getModel()).setRowCount(0);
    }

    public boolean validarCamposTurma() {
        String mensagemErro = "";
        this.jLabelNome.setForeground(Color.black);
        this.jLabelDescricao.setForeground(Color.black);
        this.jLabelDataDeInicio.setForeground(Color.black);
        this.jLabelDataDeTermino.setForeground(Color.black);
        this.jLabelStatus.setForeground(Color.black);

        if (this.jTextFieldNome.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um nome.\n";
            this.jLabelNome.setForeground(Color.red);
        }

        if (this.jTextFieldDescricao.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma descrição.\n";
            this.jLabelDescricao.setForeground(Color.red);
        }

        if (this.jFormattedTextFieldDataDeInicio.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma data de início.\n";
            this.jLabelDataDeInicio.setForeground(Color.red);
        }

        if (this.jFormattedTextFieldDataDeTermino.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma data de término.\n";
            this.jLabelDataDeTermino.setForeground(Color.red);
        }

        if (this.jComboBoxStatus.getSelectedItem() == null) {
            mensagemErro = mensagemErro + "Insira um status.\n";
            this.jLabelStatus.setForeground(Color.red);
        }

        if (mensagemErro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Turma criada com sucesso!");
            return true;
        }

        JOptionPane.showMessageDialog(this, mensagemErro, "Erro ao cadastrar turma",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean validarCamposAdicionarTabela() {
        String mensagemErro = "";
        this.jLabelNomeColaborador.setForeground(Color.black);
        this.jLabelNomeCompetencia.setForeground(Color.black);
        this.jLabelCargaHoraria.setForeground(Color.black);
        this.jLabelConteudo.setForeground(Color.black);

        if (this.jComboBoxNomeColaborador.getSelectedItem() == null) {
            mensagemErro = mensagemErro + "Insira um colaborador.\n";
            this.jLabelNomeColaborador.setForeground(Color.red);
        }

        if (this.jComboBoxNomeCompetencia.getSelectedItem() == null) {
            mensagemErro = mensagemErro + "Insira uma competência.\n";
            this.jLabelNomeCompetencia.setForeground(Color.red);
        }

        if (this.jTextFieldCargaHoraria.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma carga horária.\n";
            this.jLabelCargaHoraria.setForeground(Color.red);
        }

//        if (!Util.verificaInteiro(this.jTextAreaConteudo.getText())) {
//            mensagemErro = mensagemErro + "Insira um valor inteiro para carga horária.\n";
//            this.jLabelCargaHoraria.setForeground(Color.red);
//        }
        if (this.jTextAreaConteudo.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um conteúdo.\n";
            this.jLabelConteudo.setForeground(Color.red);
        }

        if (mensagemErro.isEmpty()) {
            return true;
        }

        JOptionPane.showMessageDialog(this, mensagemErro, "Erro ao adicionar competência",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void inserirTabela(Colaborador colaborador, Competencia competencia,
            int cargaHoraria, String conteudo) {
        ((DefaultTableModel) this.jTableTabelaColaboradorCompetencia.getModel()).addRow(new Object[3]);
        int linha = this.jTableTabelaColaboradorCompetencia.getRowCount() - 1;
        int coluna = 0;
        this.jTableTabelaColaboradorCompetencia.setValueAt(colaborador, linha, coluna++);
        this.jTableTabelaColaboradorCompetencia.setValueAt(competencia, linha, coluna++);
        this.jTableTabelaColaboradorCompetencia.setValueAt(cargaHoraria, linha, coluna++);
        this.jTableTabelaColaboradorCompetencia.setValueAt(conteudo, linha, coluna++);
    }

    public void limparCamposAdicionarTabela() {
        this.jTextFieldCargaHoraria.setText("");
        this.jTextAreaConteudo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTabelaRegistros = new javax.swing.JPopupMenu();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabelDataDeInicio = new javax.swing.JLabel();
        jFormattedTextFieldDataDeInicio = new javax.swing.JFormattedTextField();
        jLabelDataDeTermino = new javax.swing.JLabel();
        jFormattedTextFieldDataDeTermino = new javax.swing.JFormattedTextField();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jLabelCompetencias = new javax.swing.JLabel();
        jLabelNomeColaborador = new javax.swing.JLabel();
        jComboBoxNomeColaborador = new javax.swing.JComboBox<>();
        jLabelNomeCompetencia = new javax.swing.JLabel();
        jComboBoxNomeCompetencia = new javax.swing.JComboBox<>();
        jButtonAdicionarColaboradorCompetencia = new javax.swing.JButton();
        jPanelTabelaColaboradorCompetencia = new javax.swing.JPanel();
        jScrollPaneTabelaColaboradorCompetencia = new javax.swing.JScrollPane();
        jTableTabelaColaboradorCompetencia = new javax.swing.JTable();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelCargaHoraria = new javax.swing.JLabel();
        jTextFieldCargaHoraria = new javax.swing.JTextField();
        jLabelConteudo = new javax.swing.JLabel();
        jScrollPaneConteudo = new javax.swing.JScrollPane();
        jTextAreaConteudo = new javax.swing.JTextArea();

        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenuTabelaRegistros.add(jMenuItemExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Cadastro de Turma de Formação");

        jLabelNome.setText("Nome");

        jLabelDescricao.setText("Descrição");

        jLabelDataDeInicio.setText("Data de Início");

        try {
            jFormattedTextFieldDataDeInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelDataDeTermino.setText("Data de Término");

        try {
            jFormattedTextFieldDataDeTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelStatus.setText("Status");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Iniciada", "Concluída" }));

        jLabelCompetencias.setText("Adicionar Competências");

        jLabelNomeColaborador.setText("Colaborador");

        jComboBoxNomeColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeColaboradorActionPerformed(evt);
            }
        });

        jLabelNomeCompetencia.setText("Competência");

        jButtonAdicionarColaboradorCompetencia.setText("Adicionar");
        jButtonAdicionarColaboradorCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarColaboradorCompetenciaActionPerformed(evt);
            }
        });

        jTableTabelaColaboradorCompetencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colaborador", "Competência", "Carga Horária", "Conteúdo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabelaColaboradorCompetencia.setComponentPopupMenu(jPopupMenuTabelaRegistros);
        jScrollPaneTabelaColaboradorCompetencia.setViewportView(jTableTabelaColaboradorCompetencia);

        javax.swing.GroupLayout jPanelTabelaColaboradorCompetenciaLayout = new javax.swing.GroupLayout(jPanelTabelaColaboradorCompetencia);
        jPanelTabelaColaboradorCompetencia.setLayout(jPanelTabelaColaboradorCompetenciaLayout);
        jPanelTabelaColaboradorCompetenciaLayout.setHorizontalGroup(
            jPanelTabelaColaboradorCompetenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaColaboradorCompetenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabelaColaboradorCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTabelaColaboradorCompetenciaLayout.setVerticalGroup(
            jPanelTabelaColaboradorCompetenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabelaColaboradorCompetenciaLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPaneTabelaColaboradorCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelCargaHoraria.setText("Carga Horária");

        jLabelConteudo.setText("Conteúdo");

        jTextAreaConteudo.setColumns(20);
        jTextAreaConteudo.setRows(5);
        jScrollPaneConteudo.setViewportView(jTextAreaConteudo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPesquisar)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jFormattedTextFieldDataDeInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataDeInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataDeTermino)
                            .addComponent(jFormattedTextFieldDataDeTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStatus)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(249, 249, 249)
                        .addComponent(jLabelDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCargaHoraria)
                                .addGap(71, 71, 71)
                                .addComponent(jLabelConteudo))
                            .addComponent(jTextFieldCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompetencias))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneConteudo)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelTabelaColaboradorCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNomeColaborador)
                                    .addComponent(jComboBoxNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNomeCompetencia)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxNomeCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAdicionarColaboradorCompetencia)))))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButtonPesquisar)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataDeInicio)
                    .addComponent(jLabelDataDeTermino)
                    .addComponent(jLabelStatus))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataDeInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataDeTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeColaborador)
                    .addComponent(jLabelNomeCompetencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxNomeCompetencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCompetencias))
                    .addComponent(jButtonAdicionarColaboradorCompetencia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelConteudo)
                            .addComponent(jLabelCargaHoraria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTabelaColaboradorCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonCadastrar)
                        .addGap(56, 56, 56)
                        .addComponent(jButtonEditar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        gerenciadorInterfaceGrafica.abrirPesquisaTurma();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.jComboBoxNomeColaborador.removeAllItems();
        carregarComboBoxColaboradores();
        this.jComboBoxNomeColaborador.setSelectedItem(null);
    }//GEN-LAST:event_formComponentShown

    private void jComboBoxNomeColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeColaboradorActionPerformed
        this.jComboBoxNomeCompetencia.removeAllItems();
        carregarComboBoxCompetencias();
    }//GEN-LAST:event_jComboBoxNomeColaboradorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.jComboBoxNomeCompetencia.removeAllItems();
        this.jComboBoxNomeColaborador.removeAllItems();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonAdicionarColaboradorCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarColaboradorCompetenciaActionPerformed
        if (validarCamposAdicionarTabela()) {
            Colaborador colaborador = new Colaborador();
            colaborador = (Colaborador) this.jComboBoxNomeColaborador.getSelectedItem();
            Competencia competencia = new Competencia();
            competencia = (Competencia) this.jComboBoxNomeCompetencia.getSelectedItem();
            inserirTabela(colaborador,
                    competencia,
                    Integer.parseInt(this.jTextFieldCargaHoraria.getText()),
                    this.jTextAreaConteudo.getText());
            System.out.println(this.jTextFieldCargaHoraria.getText());
            limparCamposAdicionarTabela();
        }
    }//GEN-LAST:event_jButtonAdicionarColaboradorCompetenciaActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        if (validarCamposTurma()) {
            Turma turma = new Turma();
            turma.setNome(this.jTextFieldNome.getText());
            turma.setDescricao(this.jTextFieldDescricao.getText());
            turma.setStatus(this.jComboBoxStatus.getSelectedItem().toString());
            Date dataInicio = new Date();
            Date dataTermino = new Date();
            try {
                dataInicio = Util.strToDate(this.jFormattedTextFieldDataDeInicio.getText());
                dataTermino = Util.strToDate(this.jFormattedTextFieldDataDeTermino.getText());
            } catch (ParseException ex) {
                Logger.getLogger(DialogCadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            }
            turma.setDataInicio(dataInicio);
            turma.setDataTermino(dataTermino);
            int novoId = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().inserirTurma(turma);
            turma.setIdTurma(novoId);
            for (int i = 0; i < this.jTableTabelaColaboradorCompetencia.getRowCount(); i++) {
                TurmaColaboradorCompetencia novoRegistro = new TurmaColaboradorCompetencia();
                TurmaColaboradorCompetenciaId novoIdComposto = new TurmaColaboradorCompetenciaId();
                novoIdComposto.setTurma(turma);
                novoIdComposto.setColaborador((Colaborador) this.jTableTabelaColaboradorCompetencia.getValueAt(i, 0));
                novoIdComposto.setCompetencia((Competencia) this.jTableTabelaColaboradorCompetencia.getValueAt(i, 1));
                novoRegistro.setId(novoIdComposto);
                novoRegistro.setCargaHoraria((int) this.jTableTabelaColaboradorCompetencia.getValueAt(i, 2));
                novoRegistro.setConteudo((String) this.jTableTabelaColaboradorCompetencia.getValueAt(i, 3));
                this.gerenciadorInterfaceGrafica.getGerenciadorDominio().inserirTurmaColaboradorCompetencia(novoRegistro);
            }
            limparCampos();
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        int linha = this.jTableTabelaColaboradorCompetencia.getSelectedRow();
        if (linha >= 0) {
            ((DefaultTableModel) this.jTableTabelaColaboradorCompetencia.getModel()).removeRow(linha);
            return;
        }
        JOptionPane.showMessageDialog(this, "Selecione uma linha");
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarColaboradorCompetencia;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<Colaborador> jComboBoxNomeColaborador;
    private javax.swing.JComboBox<Competencia> jComboBoxNomeCompetencia;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeTermino;
    private javax.swing.JLabel jLabelCargaHoraria;
    private javax.swing.JLabel jLabelCompetencias;
    private javax.swing.JLabel jLabelConteudo;
    private javax.swing.JLabel jLabelDataDeInicio;
    private javax.swing.JLabel jLabelDataDeTermino;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeColaborador;
    private javax.swing.JLabel jLabelNomeCompetencia;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPanel jPanelTabelaColaboradorCompetencia;
    private javax.swing.JPopupMenu jPopupMenuTabelaRegistros;
    private javax.swing.JScrollPane jScrollPaneConteudo;
    private javax.swing.JScrollPane jScrollPaneTabelaColaboradorCompetencia;
    private javax.swing.JTable jTableTabelaColaboradorCompetencia;
    private javax.swing.JTextArea jTextAreaConteudo;
    private javax.swing.JTextField jTextFieldCargaHoraria;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
