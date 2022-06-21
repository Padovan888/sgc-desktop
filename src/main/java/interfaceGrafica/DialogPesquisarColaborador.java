package interfaceGrafica;

import dominio.Colaborador;
import gerenciaTarefas.GerenciadorInterfaceGrafica;
import gerenciaTarefas.Util;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogPesquisarColaborador extends javax.swing.JDialog {

    private GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica;

    private Colaborador colaboradorSelecionado;

    public DialogPesquisarColaborador(java.awt.Frame parent, boolean modal, GerenciadorInterfaceGrafica gerenciador) {
        super(parent, modal);
        initComponents();
        gerenciadorInterfaceGrafica = gerenciador;
        this.colaboradorSelecionado = null;
    }

    public Colaborador getColaboradorSelecionado() {
        return colaboradorSelecionado;
    }

    public void setColaboradorSelecionado(Colaborador colaboradorSelecionado) {
        this.colaboradorSelecionado = colaboradorSelecionado;
    }

    public void excluirLinhasTabela() {
        ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).setRowCount(0);
    }

    public void converterFormatoData() throws ParseException {
        int quantidadeLinhas = this.jTableTabelaPesquisa.getRowCount();

        for (int i = 0; i < quantidadeLinhas; i++) {
            String dataConvertida;
            dataConvertida = Util.dateToStr((Date) this.jTableTabelaPesquisa.getValueAt(i, 2));
            this.jTableTabelaPesquisa.setValueAt(dataConvertida, i, 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox<>();
        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPaneTabelaPesquisa = new javax.swing.JScrollPane();
        jTableTabelaPesquisa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Colaborador");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Pesquisar Colaborador");

        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Senioridade" }));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableTabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Data de Nascimento", "Senioridade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTabelaPesquisa.setViewportView(jTableTabelaPesquisa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonPesquisar))
                    .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelTitulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPaneTabelaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        List<Colaborador> colaboradores;
        try {
            if (this.jTextFieldTextoPesquisa.getText().equals("")) {
                colaboradores = this.gerenciadorInterfaceGrafica.getGerenciadorDominio().listarColaboradores();
            } else {
                colaboradores = this.gerenciadorInterfaceGrafica.getGerenciadorDominio()
                        .pesquisarColaborador(this.jTextFieldTextoPesquisa.getText(),
                                this.jComboBoxTipoPesquisa.getSelectedIndex());
            }

            this.excluirLinhasTabela();

            for (Colaborador colaborador : colaboradores) {
                ((DefaultTableModel) this.jTableTabelaPesquisa.getModel()).addRow(colaborador.toArray());
            }

            this.converterFormatoData();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar competência. Erro: " + ex,
                    "Erro ao realizar consulta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxTipoPesquisa;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPaneTabelaPesquisa;
    private javax.swing.JTable jTableTabelaPesquisa;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables
}
