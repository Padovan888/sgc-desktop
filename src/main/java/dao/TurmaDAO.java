package dao;

import dominio.Turma;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TurmaDAO extends GenericDAO {

    public List<Turma> listarTurmas() {
        return listar(Turma.class);
    }

    private List<Turma> pesquisar(String pesquisar, int tipo) {
        List lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Turma.class);

            Root tabela = consulta.from(Turma.class);

            consulta.distinct(true);

            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesquisar + "%");
                    break;

                case 2:
                    restricoes = builder.like(tabela.get("status"), pesquisar + "%");
                    break;
            }

            consulta.where(restricoes);

            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }

    public List<Turma> pesquisarPorNome(String nome) throws ClassNotFoundException, SQLException {
        return pesquisar(nome, 1);
    }

    public List<Turma> pesquisarPorStatus(String status) throws ClassNotFoundException, SQLException {
        return pesquisar(status, 2);
    }

}
