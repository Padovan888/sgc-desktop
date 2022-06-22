package interfaceGrafica;

import dominio.Turma;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import gerenciaTarefas.Util;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogPesquisarTurma extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    private Turma turmaSelecionada;

    public DialogPesquisarTurma(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
//        super(parent, modal);
        initComponents();
        gerenciadorInterfaceGrafica = gerenciador;
        this.turmaSelecionada = null;
    }

    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(Turma turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }

    private void excluirLinhasTabela() {
        ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).setRowCount(0);
    }

    public void converterFormatoData() throws ParseException {
        int quantidadeLinhas = this.jTableTabelaPesquisa.getRowCount();

        for (int i = 0; i < quantidadeLinhas; i++) {
            String dataInicioConvertida;
            String dataTerminoConvertida;
            dataInicioConvertida = Util.dateToStr((Date) this.jTableTabelaPesquisa.getValueAt(i, 1));
            this.jTableTabelaPesquisa.setValueAt(dataInicioConvertida, i, 1);
            dataTerminoConvertida = Util.dateToStr((Date) this.jTableTabelaPesquisa.getValueAt(i, 2));
            this.jTableTabelaPesquisa.setValueAt(dataTerminoConvertida, i, 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOpcoesTabela = new javax.swing.JPopupMenu();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPaneTabelaPesquisa = new javax.swing.JScrollPane();
        jTableTabelaPesquisa = new javax.swing.JTable();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox<>();

        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenuOpcoesTabela.add(jMenuItemExcluir);

        jMenuItemEditar.setText("Editar");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenuOpcoesTabela.add(jMenuItemEditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Pesquisar Turma de Formação");

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
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Data de Início", "Data de Término", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabelaPesquisa.setComponentPopupMenu(jPopupMenuOpcoesTabela);
        jScrollPaneTabelaPesquisa.setViewportView(jTableTabelaPesquisa);

        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Status" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitulo)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonPesquisarFocusGained
        this.jButtonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonPesquisarFocusGained

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        List<Turma> turmas;
        try {
            if (this.jTextFieldPesquisar.getText().equals("")) {
                turmas = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().listarTurmas();
            } else {
                turmas = this.gerenciadorInterfaceGrafica.getGerenciadorDominio()
                        .pesquisarTurma(this.jTextFieldPesquisar.getText(),
                                this.jComboBoxTipoPesquisa.getSelectedIndex());
            }

            this.excluirLinhasTabela();

            for (Turma turma : turmas) {
                ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).addRow(turma.toArray());
            }

            this.converterFormatoData();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar turma" + ex,
                    "Erro ao realizar pesquisa", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        int linha;
        linha = this.jTableTabelaPesquisa.getSelectedRow();
        if (linha >= 0) {
            this.turmaSelecionada = (Turma) this.jTableTabelaPesquisa.getValueAt(linha, 0);
            this.gerenciadorInterfaceGrafica.abrirCadastroTurma();
            this.setVisible(false);
            return;
        }

        JOptionPane.showMessageDialog(this, "Selecione uma turma !");
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.excluirLinhasTabela();
        this.jTextFieldPesquisar.setText("");
        this.turmaSelecionada = null;
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        this.setTurmaSelecionada(null);
    }//GEN-LAST:event_formComponentHidden

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        int linha;
        linha = this.jTableTabelaPesquisa.getSelectedRow();

        if (linha >= 0) {
            Turma turma = (Turma) this.jTableTabelaPesquisa.getValueAt(linha, 0);
            try {
                this.gerenciadorInterfaceGrafica.getGerenciadorDominio().excluirTurma(turma);
                ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).removeRow(linha);
            } catch (ClassNotFoundException | SQLException | PersistenceException ex) {
                JOptionPane.showMessageDialog(this, "Verifique se a turma possui colaboradores "
                        + "vinculadas. Erro: " + ex, "Erro no processo de exclusão", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Turma removida com sucesso !");
            return;
        }

        JOptionPane.showMessageDialog(this, "Selecione uma turma");
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
