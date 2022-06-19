package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColaborador;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAdmissao", nullable = false)
    private Date dataAdmissao;

    @Column(name = "senioridade", nullable = false)
    private String senioridade;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ColaboradorCompetencia", joinColumns
            = {
                @JoinColumn(name = "idColaborador")}, inverseJoinColumns
            = {
                @JoinColumn(name = "idCompetencia")})
    List<Competencia> competencias = new ArrayList<>();

    public Colaborador() {
    }

    public Colaborador(Integer idColaborador, String nome, String cpf, String email, Date dataNascimento, String senioridade, Date dataAdmissao) {
        this.idColaborador = idColaborador;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senioridade = senioridade;
        this.dataAdmissao = dataAdmissao;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSenioridade(String senioridade) {
        this.senioridade = senioridade;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
