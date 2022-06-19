package dominio;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class TurmaColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private TurmaColaboradorCompetenciaId idTurmaColaboradorCompetencia;

    @Column(name = "cargaHoraria", nullable = false)
    private int cargaHoraria;

    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    public TurmaColaboradorCompetencia() {
    }

    public TurmaColaboradorCompetencia(TurmaColaboradorCompetenciaId idTurmaColaboradorCompetencia, int cargaHoraria, String conteudo) {
        this.idTurmaColaboradorCompetencia = idTurmaColaboradorCompetencia;
        this.cargaHoraria = cargaHoraria;
        this.conteudo = conteudo;
    }

    public TurmaColaboradorCompetenciaId getidTurmaColaboradorCompetencia() {
        return idTurmaColaboradorCompetencia;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setId(TurmaColaboradorCompetenciaId idTurmaColaboradorCompetencia) {
        this.idTurmaColaboradorCompetencia = idTurmaColaboradorCompetencia;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
