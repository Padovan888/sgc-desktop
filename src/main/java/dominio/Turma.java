package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataInicio", nullable = false)
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataTermino", nullable = false)
    private Date dataTermino;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "idTurmaColaboradorCompetencia.turma", fetch = FetchType.EAGER)
    private List<TurmaColaboradorCompetencia> turmaColaboradorCompetencia = new ArrayList<>();

    public Turma() {
    }

    public Turma(Integer idTurma, String nome, String descricao, Date dataInicio, Date dataTermino, String status) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public List<TurmaColaboradorCompetencia> getTurmaColaboradorCompetencia() {
        return turmaColaboradorCompetencia;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTurmaColaboradorCompetencia(List<TurmaColaboradorCompetencia> turmaColaboradorCompetencia) {
        this.turmaColaboradorCompetencia = turmaColaboradorCompetencia;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{this, this.getDataInicio(), this.getDataTermino(), this.getStatus()};
    }

}
