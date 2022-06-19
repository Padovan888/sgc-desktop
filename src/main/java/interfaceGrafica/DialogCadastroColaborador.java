package interfaceGrafica;

import dominio.Colaborador;
import dominio.Competencia;
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

public class DialogCadastroColaborador extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    public DialogCadastroColaborador(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        gerenciadorInterfaceGrafica = gerenciador;
        initComponents();
    }

    public void limparCampos() {
        this.jTextFieldNome.setText("");
        this.jFormattedTextFieldCpf.setText("");
        this.jTextFieldEmail.setText("");
        this.jFormattedTextFieldDataDeNascimento.setText("");
        this.jFormattedTextFieldDataDeAdmissao.setText("");
        removerLinhasTabela();
    }

    public boolean validarCampos() {
        String mensagemErro = "";
        this.jLabelNome.setForeground(Color.black);
        this.jLabelCpf.setForeground(Color.black);
        this.jLabelEmail.setForeground(Color.black);
        this.jLabelDataDeNascimento.setForeground(Color.black);
        this.jLabelSenioridade.setForeground(Color.black);
        this.jLabelDataDeAdmissao.setForeground(Color.black);

        if (this.jTextFieldNome.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um nome.\n";
            this.jLabelNome.setForeground(Color.red);
        }

        if (this.jFormattedTextFieldCpf.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um cpf.\n";
            this.jLabelCpf.setForeground(Color.red);
        }

//        if (Util.isCPF(this.jFormattedTextFieldCpf.getText())
//                && !this.jFormattedTextFieldCpf.getText().isEmpty()) {
//            mensagemErro = mensagemErro + "Insira um CPF válido.\n";
//            this.jLabelCpf.setForeground(Color.red);
//        }
        if (this.jTextFieldNome.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um email.\n";
            this.jLabelEmail.setForeground(Color.red);
        }

        if (this.jFormattedTextFieldDataDeNascimento.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma data de nascimento.\n";
            this.jLabelDataDeNascimento.setForeground(Color.red);
        }

        if (this.jComboBoxSenioridade.getSelectedItem().toString().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma senioridade.\n";
            this.jLabelSenioridade.setForeground(Color.red);
        }

        if (this.jFormattedTextFieldDataDeAdmissao.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma data de admissão.\n";
            this.jLabelDataDeAdmissao.setForeground(Color.red);
        }

        if (mensagemErro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Colaborador criado com sucesso!");
            return true;
        }

        JOptionPane.showMessageDialog(this, mensagemErro, "Erro ao cadastrar colaborador",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void carregarComboBoxCompetencias() {
        List<Competencia> competencias;
        competencias = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().listarCompetencias();
        for (Competencia competencia : competencias) {
            this.jComboBoxCompetencias.addItem(competencia);
        }
    }

    public void inserirCompetenciaTabela(Competencia competencia) {
        ((DefaultTableModel) this.jTableTabelaCompetencias.getModel()).addRow(new Object[0]);
        int linha = this.jTableTabelaCompetencias.getRowCount() - 1;
        int coluna = 0;
        this.jTableTabelaCompetencias.setValueAt(competencia, linha, coluna);
    }

    public void removerLinhasTabela() {
        ((DefaultTableModel) this.jTableTabelaCompetencias.getModel()).setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTabelaCompetencias = new javax.swing.JPopupMenu();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelDataDeNascimento = new javax.swing.JLabel();
        jFormattedTextFieldDataDeNascimento = new javax.swing.JFormattedTextField();
        jLabelSenioridade = new javax.swing.JLabel();
        jComboBoxSenioridade = new javax.swing.JComboBox<>();
        jLabelDataDeAdmissao = new javax.swing.JLabel();
        jFormattedTextFieldDataDeAdmissao = new javax.swing.JFormattedTextField();
        jLabelCompetencias = new javax.swing.JLabel();
        jComboBoxCompetencias = new javax.swing.JComboBox<>();
        jButtonAdicionarCompetencia = new javax.swing.JButton();
        jPanelTabelaCompetencias = new javax.swing.JPanel();
        jScrollPaneTabelaCompetencias = new javax.swing.JScrollPane();
        jTableTabelaCompetencias = new javax.swing.JTable();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();

        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenuTabelaCompetencias.add(jMenuItemExcluir);

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
        jLabelTitulo.setText("Cadastro de Colaborador");

        jLabelNome.setText("Nome");

        jLabelCpf.setText("CPF");

        try {
            jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelEmail.setText("Email");

        jLabelDataDeNascimento.setText("Data de Nascimento");

        try {
            jFormattedTextFieldDataDeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelSenioridade.setText("Senioridade");

        jComboBoxSenioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estagiário", "Júnior", "Pleno", "Sênior" }));

        jLabelDataDeAdmissao.setText("Data de Admissão");

        try {
            jFormattedTextFieldDataDeAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCompetencias.setText("Adicionar Competências");

        jButtonAdicionarCompetencia.setText("Adicionar");
        jButtonAdicionarCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCompetenciaActionPerformed(evt);
            }
        });

        jTableTabelaCompetencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Competências"
            }
        ));
        jTableTabelaCompetencias.setComponentPopupMenu(jPopupMenuTabelaCompetencias);
        jScrollPaneTabelaCompetencias.setViewportView(jTableTabelaCompetencias);

        javax.swing.GroupLayout jPanelTabelaCompetenciasLayout = new javax.swing.GroupLayout(jPanelTabelaCompetencias);
        jPanelTabelaCompetencias.setLayout(jPanelTabelaCompetenciasLayout);
        jPanelTabelaCompetenciasLayout.setHorizontalGroup(
            jPanelTabelaCompetenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaCompetenciasLayout.createSequentialGroup()
                .addComponent(jScrollPaneTabelaCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTabelaCompetenciasLayout.setVerticalGroup(
            jPanelTabelaCompetenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabelaCompetencias, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxSenioridade, javax.swing.GroupLayout.Alignment.LEADING, 0, 153, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                                .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabelEmail)))
                                    .addComponent(jLabelSenioridade))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelDataDeAdmissao)
                                        .addComponent(jLabelDataDeNascimento)
                                        .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldDataDeNascimento)
                                        .addComponent(jFormattedTextFieldDataDeAdmissao))
                                    .addComponent(jLabelCpf)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCompetencias)
                                .addGap(38, 38, 38)
                                .addComponent(jComboBoxCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButtonAdicionarCompetencia))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelTabelaCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jButtonCadastrar)
                                .addGap(48, 48, 48)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisar)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabelTitulo)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPesquisar)
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelDataDeNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenioridade)
                    .addComponent(jLabelDataDeAdmissao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSenioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataDeAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCompetencias)
                    .addComponent(jComboBoxCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarCompetencia))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanelTabelaCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCadastrar)
                            .addComponent(jButtonEditar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        gerenciadorInterfaceGrafica.abrirPesquisaColaborador();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonAdicionarCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCompetenciaActionPerformed
        if (this.jComboBoxCompetencias.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma competência");
            return;
        }
        Competencia competencia = new Competencia();
        competencia = (Competencia) this.jComboBoxCompetencias.getSelectedItem();
        inserirCompetenciaTabela(competencia);
    }//GEN-LAST:event_jButtonAdicionarCompetenciaActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        if (validarCampos()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setNome(this.jTextFieldNome.getText());
            String cpfSomenteNumeros = Util.retirarFormacaoCpf(this.jFormattedTextFieldCpf.getText());
            colaborador.setCpf(cpfSomenteNumeros);
            colaborador.setEmail(this.jTextFieldEmail.getText());
            colaborador.setSenioridade(this.jComboBoxSenioridade.getSelectedItem().toString());
            List<Competencia> competencias = new ArrayList<Competencia>();
            for (int i = 0; i < this.jTableTabelaCompetencias.getRowCount(); i++) {
                Competencia competenciaSelecionada = new Competencia();
                competenciaSelecionada = (Competencia) this.jTableTabelaCompetencias.getValueAt(i, 0);
                competencias.add(competenciaSelecionada);
            }
            colaborador.setCompetencias(competencias);
            Date dataNascimento = new Date();
            Date dataAdmissao = new Date();
            try {
                dataNascimento = Util.strToDate(this.jFormattedTextFieldDataDeNascimento.getText());
                dataAdmissao = Util.strToDate(this.jFormattedTextFieldDataDeAdmissao.getText());
            } catch (ParseException ex) {
                Logger.getLogger(DialogCadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
            }
            colaborador.setDataNascimento(dataNascimento);
            colaborador.setDataAdmissao(dataAdmissao);
            this.gerenciadorInterfaceGrafica.getGerenciadorDominio().inserirColaborador(colaborador);
            limparCampos();
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregarComboBoxCompetencias();
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.jComboBoxCompetencias.removeAllItems();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        int linha = this.jTableTabelaCompetencias.getSelectedRow();
        if (linha >= 0) {
            ((DefaultTableModel) this.jTableTabelaCompetencias.getModel()).removeRow(linha);
            return;
        }
        JOptionPane.showMessageDialog(this, "Selecione uma linha");
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCompetencia;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<Competencia> jComboBoxCompetencias;
    private javax.swing.JComboBox<String> jComboBoxSenioridade;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeAdmissao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeNascimento;
    private javax.swing.JLabel jLabelCompetencias;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataDeAdmissao;
    private javax.swing.JLabel jLabelDataDeNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenioridade;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPanel jPanelTabelaCompetencias;
    private javax.swing.JPopupMenu jPopupMenuTabelaCompetencias;
    private javax.swing.JScrollPane jScrollPaneTabelaCompetencias;
    private javax.swing.JTable jTableTabelaCompetencias;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
