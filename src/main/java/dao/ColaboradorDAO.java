package dao;

import dominio.Colaborador;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ColaboradorDAO extends GenericDAO {

    public List<Colaborador> listarColaboradores() {
        return listar(Colaborador.class);
    }

    private List<Colaborador> pesquisar(String pesquisar, int tipo) {
        List lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Colaborador.class);

            consulta.distinct(true);

            Root tabela = consulta.from(Colaborador.class);

            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesquisar + "%");
                    break;

                case 2:
                    restricoes = builder.like(tabela.get("senioridade"), pesquisar + "%");
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

    public List<Colaborador> pesquisarPorNome(String nome) throws ClassNotFoundException, SQLException {
        return pesquisar(nome, 1);
    }

    public List<Colaborador> pesquisarPorSenioridade(String senioridade) throws ClassNotFoundException, SQLException {
        return pesquisar(senioridade, 2);
    }

}
