/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.model;

/**
 *
 * @author andreas
 */
public class Usuario {
    
    private Long CodigoUsuario;
    private String nome;
    private Departamento departamento;

    public Usuario(Long CodigoUsuario, String nome, Departamento departamento) {
        this.CodigoUsuario = CodigoUsuario;
        this.nome = nome;
        this.departamento = departamento;
    }
   
    
  
   
    public Usuario() {
    }
    
    public Usuario(Departamento departamento){
        this.departamento = departamento;
    }

    public Long getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(Long CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
}
