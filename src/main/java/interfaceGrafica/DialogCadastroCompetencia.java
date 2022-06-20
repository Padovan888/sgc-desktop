package interfaceGrafica;

import dominio.Competencia;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class DialogCadastroCompetencia extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    public DialogCadastroCompetencia(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        gerenciadorInterfaceGrafica = gerenciador;
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

        if (mensagemErro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Competência criada com sucesso!");
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
        jButtonPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Competência");
        setResizable(false);

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

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButtonPesquisarFocusGained(evt);
            }
        });
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
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelNome)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(48, 48, 48)
                            .addComponent(jButtonPesquisar))
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(19, 19, 19)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(21, 21, 21)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
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

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        gerenciadorInterfaceGrafica.abrirPesquisaCompetencia();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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

    private void jButtonPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonPesquisarFocusGained
        this.jButtonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonPesquisarFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
