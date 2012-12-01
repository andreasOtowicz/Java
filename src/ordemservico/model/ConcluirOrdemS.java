/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.model;

/**
 *
 * @author andreas
 */
public class ConcluirOrdemS {

    private Long codConclusao;
    private String dataConclusao;
    private String horaConclusao;
    private AbrirOrdemS numeroOrdem;

    public ConcluirOrdemS() {
    }
    
    public ConcluirOrdemS(AbrirOrdemS numeroordem){
        this.numeroOrdem = numeroordem;
    }

    public ConcluirOrdemS(Long codConclusao, String dataConclusao, String horaConclusao, AbrirOrdemS numeroOrdem) {
        this.codConclusao = codConclusao;
        this.dataConclusao = dataConclusao;
        this.horaConclusao = horaConclusao;
        this.numeroOrdem = numeroOrdem;
    }

    public Long getCodConclusao() {
        return codConclusao;
    }

    public void setCodConclusao(Long codConclusao) {
        this.codConclusao = codConclusao;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getHoraConclusao() {
        return horaConclusao;
    }

    public void setHoraConclusao(String horaConclusao) {
        this.horaConclusao = horaConclusao;
    }

    public AbrirOrdemS getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(AbrirOrdemS numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }
    
    
}
