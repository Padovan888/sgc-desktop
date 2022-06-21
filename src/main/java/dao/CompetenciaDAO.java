package dao;

import dominio.Competencia;
import java.sql.SQLException;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CompetenciaDAO extends GenericDAO {

    public List<Competencia> listarCompetencias() {
        return listar(Competencia.class);
    }

    private List<Competencia> pesquisar(String pesquisar, int tipo) {
        List lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Competencia.class);

            Root tabela = consulta.from(Competencia.class);

            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesquisar + "%");
                    break;

                case 2:
                    restricoes = builder.like(tabela.get("categoria"), pesquisar + "%");
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

    public List<Competencia> pesquisarPorNome(String nome) throws ClassNotFoundException, SQLException {
        return pesquisar(nome, 1);
    }

    public List<Competencia> pesquisarPorCategoria(String categoria) throws ClassNotFoundException, SQLException {
        return pesquisar(categoria, 2);
    }
    
}
