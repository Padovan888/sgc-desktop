package gerenciaTarefas;

import dao.ColaboradorDAO;
import dao.CompetenciaDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import dominio.Colaborador;
import dominio.Competencia;
import dominio.Turma;
import dominio.TurmaColaboradorCompetencia;
import java.util.List;

public class GerenciadorDominio {

    private GenericDAO genericDAO;
    private CompetenciaDAO competenciaDAO;
    private ColaboradorDAO colaboradorDAO;

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
        this.genericDAO = new GenericDAO();
        this.competenciaDAO = new CompetenciaDAO();
        this.colaboradorDAO = new ColaboradorDAO();
    }

    public void inserirCompetencia(Competencia novaCompetencia) {
//        Competencia competencia = new Competencia();
//        competencia.setNome(novaCompetencia.getNome());
//        competencia.setDescricao(novaCompetencia.getDescricao());
//        competencia.setCategoria(novaCompetencia.getCategoria());
        this.competenciaDAO.inserir(novaCompetencia);
    }

    public List<Competencia> listarCompetencias() {
        return this.competenciaDAO.listarCompetencias();
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

    public void inserirTurmaColaboradorCompetencia(TurmaColaboradorCompetencia novoTurmaColaboradorCompetencia) {
        TurmaColaboradorCompetencia turmaColaboradorCompetencia = new TurmaColaboradorCompetencia();
        turmaColaboradorCompetencia.setId(novoTurmaColaboradorCompetencia.getidTurmaColaboradorCompetencia());
        turmaColaboradorCompetencia.setCargaHoraria(novoTurmaColaboradorCompetencia.getCargaHoraria());
        turmaColaboradorCompetencia.setConteudo(novoTurmaColaboradorCompetencia.getConteudo());
        this.genericDAO.inserir(turmaColaboradorCompetencia);
    }

}
