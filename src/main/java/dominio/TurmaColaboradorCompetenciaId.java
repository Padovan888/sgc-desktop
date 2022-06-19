package dominio;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TurmaColaboradorCompetenciaId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTurma")
    private Turma turma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idColaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompetencia")
    private Competencia competencia;

    public TurmaColaboradorCompetenciaId() {
    }

    public TurmaColaboradorCompetenciaId(Turma turma, Colaborador colaborador, Competencia competencia) {
        this.turma = turma;
        this.colaborador = colaborador;
        this.competencia = competencia;
    }

    public Turma getTurma() {
        return turma;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaColaboradorCompetenciaId that = (TurmaColaboradorCompetenciaId) o;
        return Objects.equals(turma, that.turma) && Objects.equals(colaborador, that.colaborador) && Objects.equals(competencia, that.competencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turma, colaborador, competencia);
    }

}
