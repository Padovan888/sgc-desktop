package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Competencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompetencia;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "colaboradorcompetencia", joinColumns
            = {
                @JoinColumn(name = "idCompetencia")}, inverseJoinColumns
            = {
                @JoinColumn(name = "idColaborador")})
    private List<Colaborador> colaboradores = new ArrayList<Colaborador>();

    public Competencia() {
    }

    public Competencia(Integer idCompetencia, String nome, String descricao, String categoria) {
        this.idCompetencia = idCompetencia;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setIdCompetencia(Integer id) {
        this.idCompetencia = idCompetencia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{this, this.getDescricao(), this.getCategoria()};
    }

}
