package interfaceGrafica;

import dominio.Competencia;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogPesquisarCompetencia extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;
    private Competencia competenciaSelecionada;

    public DialogPesquisarCompetencia(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        initComponents();
        this.gerenciadorInterfaceGrafica = gerenciador;
        this.competenciaSelecionada = null;
    }

    public Competencia getCompetenciaSelecionada() {
        return competenciaSelecionada;
    }

    public void setCompetenciaSelecionada(Competencia competenciaSelecionada) {
        this.competenciaSelecionada = competenciaSelecionada;
    }

    private void excluirLinhasTabela() {
        ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOpcoesTabela = new javax.swing.JPopupMenu();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox<>();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPaneTabelaPesquisa = new javax.swing.JScrollPane();
        jTableTabelaPesquisa = new javax.swing.JTable();

        jMenuItemEditar.setText("Editar");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenuOpcoesTabela.add(jMenuItemEditar);

        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenuOpcoesTabela.add(jMenuItemExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Competência");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Pesquisar Competência");

        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Categoria" }));

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

        jTableTabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabelaPesquisa.setComponentPopupMenu(jPopupMenuOpcoesTabela);
        jScrollPaneTabelaPesquisa.setViewportView(jTableTabelaPesquisa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPesquisar)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitulo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonPesquisarFocusGained
        this.jButtonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonPesquisarFocusGained

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        List<Competencia> competencias;
        try {
            if (this.jTextFieldPesquisar.getText().equals("")) {
                competencias = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().listarCompetencias();
            } else {
                competencias = this.gerenciadorInterfaceGrafica.getGerenciadorDominio()
                        .pesquisarCompetencia(this.jTextFieldPesquisar.getText(),
                                this.jComboBoxTipoPesquisa.getSelectedIndex());
            }

            this.excluirLinhasTabela();

            for (Competencia competencia : competencias) {
                ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).addRow(competencia.toArray());
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar competência" + ex,
                    "Erro ao realizar pesquisa", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        int linha;
        linha = this.jTableTabelaPesquisa.getSelectedRow();
        if (linha >= 0) {
            this.competenciaSelecionada = (Competencia) this.jTableTabelaPesquisa.getValueAt(linha, 0);
            this.gerenciadorInterfaceGrafica.abrirCadastroCompetencia();
            this.setVisible(false);
            return;
        }
        JOptionPane.showMessageDialog(this, "Selecione uma competência !");
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.excluirLinhasTabela();
        this.jTextFieldPesquisar.setText("");
        this.competenciaSelecionada = null;
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        this.setCompetenciaSelecionada(null);
    }//GEN-LAST:event_formComponentHidden

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        int linha;
        linha = this.jTableTabelaPesquisa.getSelectedRow();

        if (linha >= 0) {
            Competencia competencia = (Competencia) this.jTableTabelaPesquisa.getValueAt(linha, 0);
            try {
                this.gerenciadorInterfaceGrafica.getGerenciadorDominio().excluirCompetencia(competencia);
                ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).removeRow(linha);
            } catch (ClassNotFoundException | SQLException | PersistenceException ex) {
                JOptionPane.showMessageDialog(this, "Verifique se a competência se encontra vinculada "
                        + "a um colaborador. Erro: " + ex, "Erro no processo de exclusão", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Competência removida com sucesso !");
            return;
        }

        JOptionPane.showMessageDialog(this, "Selecione uma competência");
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxTipoPesquisa;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPopupMenu jPopupMenuOpcoesTabela;
    private javax.swing.JScrollPane jScrollPaneTabelaPesquisa;
    private javax.swing.JTable jTableTabelaPesquisa;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
