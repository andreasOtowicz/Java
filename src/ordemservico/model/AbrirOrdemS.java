/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.model;

/**
 *
 * @author andreas
 */
public class AbrirOrdemS {

    private Long numeroOrdem;
    private String dataEntrada;
    private String horaEntrada;
    private String caracteristica;
    private String prioridade;
    private String problema;
    private Usuario usuario;
    private Departamento departamento;

    public AbrirOrdemS() {
    }

    public AbrirOrdemS(Usuario usuario) {
        this.usuario = usuario;
    }

    public AbrirOrdemS(Long numeroOrdem, Usuario usuario, String dataEntrada, String horaEntrada, String caracteristica, String prioridade, String problema, Departamento departamento) {
        this.numeroOrdem = numeroOrdem;
        this.usuario = usuario;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.caracteristica = caracteristica;
        this.prioridade = prioridade;
        this.problema = problema;
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Long getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(Long numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

}
