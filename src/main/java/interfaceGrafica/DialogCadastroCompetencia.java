package interfaceGrafica;

import dominio.Competencia;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class DialogCadastroCompetencia extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    private Competencia competenciaEditar;

    public DialogCadastroCompetencia(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        gerenciadorInterfaceGrafica = gerenciador;
        competenciaEditar = null;
        initComponents();
    }

    public void limparCampos() {
        this.jTextFieldNome.setText("");
        this.jTextFieldDescricao.setText("");
    }

    public void labelsComCorPadrao() {
        this.jLabelNome.setForeground(Color.black);
        this.jLabelDescricao.setForeground(Color.black);
        this.jLabelCategoria.setForeground(Color.black);
    }

    public boolean validarCampos() {
        String mensagemErro = "";

        labelsComCorPadrao();

        if (this.jTextFieldNome.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira um nome.\n";
            this.jLabelNome.setForeground(Color.red);
        }

        if (this.jTextFieldDescricao.getText().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma descrição.\n";
            this.jLabelDescricao.setForeground(Color.red);
        }

        if (this.jComboBoxCategoria.getSelectedItem().toString().isEmpty()) {
            mensagemErro = mensagemErro + "Insira uma categoria.\n";
            this.jLabelCategoria.setForeground(Color.red);
        }

        if (mensagemErro.isEmpty() && this.competenciaEditar == null) {
            JOptionPane.showMessageDialog(this, "Competência criada com sucesso!");
            return true;
        }

        if (mensagemErro.isEmpty() && this.competenciaEditar != null) {
            JOptionPane.showMessageDialog(this, "Competência editada com sucesso!");
            return true;
        }

        JOptionPane.showMessageDialog(this, mensagemErro, "Erro ao cadastrar a competência", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public Competencia novaCompetencia() {
        Competencia competencia = new Competencia();
        competencia.setNome(this.jTextFieldNome.getText());
        competencia.setDescricao(this.jTextFieldDescricao.getText());
        competencia.setCategoria(this.jComboBoxCategoria.getSelectedItem().toString());
        return competencia;
    }

    public void visibilidadeBotoes() {
        if (this.competenciaEditar != null) {
            this.jButtonEditar.setVisible(true);
            this.jButtonCadastrar.setVisible(false);
            return;
        }

        this.jButtonEditar.setVisible(false);
        this.jButtonCadastrar.setVisible(true);
    }

    public void preencherComboBoxCategoriaEditar(String categoria) {
        if (categoria.equals("Backend")) {
            this.jComboBoxCategoria.setSelectedIndex(0);
        }

        if (categoria.equals("Frontend")) {
            this.jComboBoxCategoria.setSelectedIndex(1);
        }

        if (categoria.equals("Banco")) {
            this.jComboBoxCategoria.setSelectedIndex(2);
        }

        if (categoria.equals("Arquitetura")) {
            this.jComboBoxCategoria.setSelectedIndex(3);
        }

        if (categoria.equals("Metodologia Ágil")) {
            this.jComboBoxCategoria.setSelectedIndex(4);
        }

        if (categoria.equals("Testes")) {
            this.jComboBoxCategoria.setSelectedIndex(5);
        }

        if (categoria.equals("Devops")) {
            this.jComboBoxCategoria.setSelectedIndex(6);
        }

        if (categoria.equals("Liderança")) {
            this.jComboBoxCategoria.setSelectedIndex(7);
        }
    }

    public void preencherCamposCompetenciaEditar() {
        if (this.competenciaEditar != null) {
            this.jTextFieldNome.setText(this.competenciaEditar.getNome());
            this.jTextFieldDescricao.setText(this.competenciaEditar.getDescricao());
            this.preencherComboBoxCategoriaEditar(this.competenciaEditar.getCategoria());
        }
    }

    public Competencia atualizarCompetenciaEditar() {
        Competencia competencia = this.competenciaEditar;
        competencia.setNome(this.jTextFieldNome.getText());
        competencia.setDescricao(this.jTextFieldDescricao.getText());
        competencia.setCategoria(this.jComboBoxCategoria.getSelectedItem().toString());
        return competencia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Competência");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Cadastro de Competência");

        jLabelNome.setText("Nome");

        jLabelDescricao.setText("Descrição");

        jLabelCategoria.setText("Categoria");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Backend", "Frontend", "Banco", "Arquitetura", "Metodologia Ágil", "Testes", "Devops", "Liderança" }));

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButtonCadastrarFocusGained(evt);
            }
        });
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButtonEditarFocusGained(evt);
            }
        });
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelDescricao)
                            .addComponent(jLabelTitulo)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(jTextFieldNome))
                        .addGap(44, 98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelCategoria)
                                .addGap(181, 181, 181)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCadastrar))
                        .addGap(19, 70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(21, 21, 21)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabelCategoria)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrar)
                        .addGap(2, 2, 2)))
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        if (validarCampos()) {
            Competencia competencia = novaCompetencia();
            this.gerenciadorInterfaceGrafica.getGerenciadorDominio().inserirCompetencia(competencia);
            limparCampos();
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonCadastrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonCadastrarFocusGained
        this.jButtonCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonCadastrarFocusGained

    private void jButtonEditarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonEditarFocusGained
        this.jButtonEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonEditarFocusGained

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (validarCampos()) {
            this.gerenciadorInterfaceGrafica.getGerenciadorDominio()
                    .alterarCompetencia(atualizarCompetenciaEditar());
            limparCampos();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.competenciaEditar = null;
        if (this.gerenciadorInterfaceGrafica.getPesquisarCompetencia() != null) {
            this.competenciaEditar = this.gerenciadorInterfaceGrafica.getCompetenciaPesquisaCompetencia();
        }
        this.visibilidadeBotoes();
        this.preencherCamposCompetenciaEditar();
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.competenciaEditar = null;
        this.limparCampos();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
