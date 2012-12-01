/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.model;

/**
 *
 * @author andreas
 */
public class Processos {
    
    private Long numeroProcesso;
    private String AcaoProcesso;
    private String statusProcesso;
    private AbrirOrdemS abrirOrdemS;
    
    public Processos(AbrirOrdemS abrirOrdemS){
        this.abrirOrdemS = abrirOrdemS;
    }

    public Processos() {
    }

    public Long getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(Long numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getAcaoProcesso() {
        return AcaoProcesso;
    }

    public void setAcaoProcesso(String AcaoProcesso) {
        this.AcaoProcesso = AcaoProcesso;
    }

    public String getStatusProcesso() {
        return statusProcesso;
    }

    public void setStatusProcesso(String statusProcesso) {
        this.statusProcesso = statusProcesso;
    }

    public AbrirOrdemS getAbrirOrdemS() {
        return abrirOrdemS;
    }

    public void setAbrirOrdemS(AbrirOrdemS abrirOrdemS) {
        this.abrirOrdemS = abrirOrdemS;
    }

   

    
}
