package dao;

import dominio.Competencia;

import java.util.List;

public class CompetenciaDAO extends GenericDAO {

    public List<Competencia> listarCompetencias() {
        return listar(Competencia.class);
    }

}
