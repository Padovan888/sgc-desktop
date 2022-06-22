package gerenciaTarefas;

import dao.ColaboradorDAO;
import dao.CompetenciaDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.TurmaColaboradorCompetenciaDAO;
import dao.TurmaDAO;
import dominio.Colaborador;
import dominio.Competencia;
import dominio.Turma;
import dominio.TurmaColaboradorCompetencia;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.PersistenceException;

public class GerenciadorDominio {
    
    private GenericDAO genericDAO;
    private CompetenciaDAO competenciaDAO;
    private ColaboradorDAO colaboradorDAO;
    private TurmaDAO turmaDAO;
    private TurmaColaboradorCompetenciaDAO turmaColaboradorCompetenciaDAO;
    
    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
        this.genericDAO = new GenericDAO();
        this.competenciaDAO = new CompetenciaDAO();
        this.colaboradorDAO = new ColaboradorDAO();
        this.turmaDAO = new TurmaDAO();
        this.turmaColaboradorCompetenciaDAO = new TurmaColaboradorCompetenciaDAO();
    }
    
    public void inserirCompetencia(Competencia competencia) {
        this.competenciaDAO.inserir(competencia);
    }
    
    public List<Competencia> listarCompetencias() {
        return this.competenciaDAO.listarCompetencias();
    }
    
    public List<Competencia> pesquisarCompetencia(String pesquisa, int tipo) throws ClassNotFoundException, SQLException {
        switch (tipo) {
            case 0:
                return this.competenciaDAO.pesquisarPorNome(pesquisa);
            case 1:
                return this.competenciaDAO.pesquisarPorCategoria(pesquisa);
            default:
                return null;
        }
    }
    
    public void alterarCompetencia(Competencia competencia) {
        this.competenciaDAO.alterar(competencia);
    }
    
    public void excluirCompetencia(Competencia competencia) throws ClassNotFoundException, SQLException, PersistenceException {
        this.competenciaDAO.excluir(competencia);
    }
    
    public void inserirColaborador(Colaborador novoColaborador) {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome(novoColaborador.getNome());
        colaborador.setCpf(novoColaborador.getCpf());
        colaborador.setEmail(novoColaborador.getEmail());
        colaborador.setDataNascimento(novoColaborador.getDataNascimento());
        colaborador.setDataAdmissao(novoColaborador.getDataAdmissao());
        colaborador.setSenioridade(novoColaborador.getSenioridade());
        colaborador.setCompetencias(novoColaborador.getCompetencias());
        this.colaboradorDAO.inserir(colaborador);
    }
    
    public List<Colaborador> listarColaboradores() {
        return this.colaboradorDAO.listarColaboradores();
    }
    
    public List<Colaborador> pesquisarColaborador(String pesquisa, int tipo) throws ClassNotFoundException, SQLException {
        switch (tipo) {
            case 0:
                return this.colaboradorDAO.pesquisarPorNome(pesquisa);
            case 1:
                return this.colaboradorDAO.pesquisarPorSenioridade(pesquisa);
            default:
                return null;
        }
    }
    
    public void alterarColaborador(Colaborador colaborador) {
        this.colaboradorDAO.alterar(colaborador);
    }
    
    public void excluirColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException, PersistenceException {
        this.colaboradorDAO.excluir(colaborador);
    }
    
    public int inserirTurma(Turma novaTurma) {
        Turma turma = new Turma();
        turma.setNome(novaTurma.getNome());
        turma.setDescricao(novaTurma.getDescricao());
        turma.setDataInicio(novaTurma.getDataInicio());
        turma.setDataTermino(novaTurma.getDataTermino());
        turma.setStatus(novaTurma.getStatus());
        turma.setTurmaColaboradorCompetencia(novaTurma.getTurmaColaboradorCompetencia());
        this.genericDAO.inserir(turma);
        return turma.getIdTurma();
    }
    
    public void alterarTurma(Turma turma) {
        this.turmaDAO.alterar(turma);
    }
    
    public List<Turma> listarTurmas() {
        return this.turmaDAO.listarTurmas();
    }
    
    public List<Turma> pesquisarTurma(String pesquisa, int tipo) throws ClassNotFoundException, SQLException {
        switch (tipo) {
            case 0:
                return this.turmaDAO.pesquisarPorNome(pesquisa);
            case 1:
                return this.turmaDAO.pesquisarPorStatus(pesquisa);
            default:
                return null;
        }
    }
    
    public void excluirTurma(Turma turma) throws ClassNotFoundException, SQLException, PersistenceException {
        this.turmaDAO.excluir(turma);
    }
    
    public void inserirTurmaColaboradorCompetencia(TurmaColaboradorCompetencia novoTurmaColaboradorCompetencia) {
        TurmaColaboradorCompetencia turmaColaboradorCompetencia = new TurmaColaboradorCompetencia();
        turmaColaboradorCompetencia.setId(novoTurmaColaboradorCompetencia.getidTurmaColaboradorCompetencia());
        turmaColaboradorCompetencia.setCargaHoraria(novoTurmaColaboradorCompetencia.getCargaHoraria());
        turmaColaboradorCompetencia.setConteudo(novoTurmaColaboradorCompetencia.getConteudo());
        this.genericDAO.inserir(turmaColaboradorCompetencia);
    }
    
    public void alterarTurmaColaboradorCompetencia(TurmaColaboradorCompetencia turmaColaboradorCompetencia) {
        this.turmaColaboradorCompetenciaDAO.alterar(turmaColaboradorCompetencia);
    }
    
}
