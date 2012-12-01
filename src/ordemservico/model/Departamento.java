/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.model;

/**
 *
 * @author andreas
 */
public class Departamento {

    private String NomeDepartamento;
    private Long codDepartamento;

    public Departamento(String NomeDepartamento, Long codDepartamento) {
        this.NomeDepartamento = NomeDepartamento;
        this.codDepartamento = codDepartamento;
    }

    public Departamento() {
    }

    public String getNomeDepartamento() {
        return NomeDepartamento;
    }

    public void setNomeDepartamento(String NomeDepartamento) {
        this.NomeDepartamento = NomeDepartamento;
    }

    public Long getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
}
