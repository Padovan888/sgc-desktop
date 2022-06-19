
package gerenciaTarefas;

import interfaceGrafica.DialogCadastroColaborador;
import interfaceGrafica.DialogCadastroCompetencia;
import interfaceGrafica.DialogCadastroTurma;
import interfaceGrafica.DialogPesquisarColaborador;
import interfaceGrafica.DialogPesquisarCompetencia;
import interfaceGrafica.DialogPesquisarTurma;
import interfaceGrafica.FramePrincipal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GerenciadorInterfaceGrafica {
    
    private FramePrincipal principal;
    private DialogCadastroCompetencia cadastroCompetencia;
    private DialogCadastroColaborador cadastroColaborador;
    private DialogCadastroTurma cadastroTurma;
    private DialogPesquisarCompetencia pesquisarCompetencia;
    private DialogPesquisarColaborador pesquisarColaborador;
    private DialogPesquisarTurma pesquisarTurma;
    
    GerenciadorDominio gerenciadorDominio;

    public GerenciadorInterfaceGrafica() {
        gerenciadorDominio = new GerenciadorDominio();
        principal = null;
        cadastroCompetencia = null;
        cadastroColaborador = null;
        cadastroTurma = null;
        pesquisarCompetencia = null;
        pesquisarColaborador = null;
        pesquisarTurma = null;
    }
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe){
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerenciadorInterfaceGrafica.class ).newInstance(parent,true,this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(principal, "Erro ao abrir a janela " + classe.getName() );
            }
        }        
        dlg.setVisible(true); 
        return dlg;
    }
    
    public void abrirJanelaPrincipal(){
        if(principal == null){
            principal = new FramePrincipal(this);
        }
        principal.setVisible(true);
    }
    
    public void abrirCadastroCompetencia(){
        cadastroCompetencia = (DialogCadastroCompetencia) abrirJanela(principal, cadastroCompetencia, DialogCadastroCompetencia.class);
    }
    
    public void abrirCadastroColaborador(){
        cadastroColaborador = (DialogCadastroColaborador) abrirJanela(principal, cadastroColaborador, DialogCadastroColaborador.class);
    }
    
    public void abrirCadastroTurma(){
        cadastroTurma = (DialogCadastroTurma) abrirJanela(principal, cadastroTurma, DialogCadastroTurma.class);
    }
    
    public void abrirPesquisaCompetencia(){
        pesquisarCompetencia = (DialogPesquisarCompetencia) abrirJanela(principal, pesquisarCompetencia, DialogPesquisarCompetencia.class);
    }
    
    public void abrirPesquisaColaborador(){
        pesquisarColaborador = (DialogPesquisarColaborador) abrirJanela(principal, pesquisarColaborador, DialogPesquisarColaborador.class);
    }
    
    public void abrirPesquisaTurma(){
        pesquisarTurma = (DialogPesquisarTurma) abrirJanela(principal, pesquisarTurma, DialogPesquisarTurma.class);
    }

    public GerenciadorDominio getGerenciadorDominio() {
        return gerenciadorDominio;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GerenciadorInterfaceGrafica gerenciadorInterfaceGrafica = new GerenciadorInterfaceGrafica();
                gerenciadorInterfaceGrafica.abrirJanelaPrincipal();
//                ConexaoHibernate.getSessionFactory();
            }
        });
    }
    
}
