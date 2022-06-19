package dao;

import dominio.Colaborador;
import java.util.List;

public class ColaboradorDAO extends GenericDAO {

    public List<Colaborador> listarColaboradores() {
        return listar(Colaborador.class);
    }

}
