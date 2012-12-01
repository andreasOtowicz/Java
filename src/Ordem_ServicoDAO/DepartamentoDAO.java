/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordem_ServicoDAO;

import java.util.List;
import ordemservico.model.Departamento;

/**
 *
 * @author andreas
 */
public interface DepartamentoDAO {
    
    void insert(Departamento departamento);
    void alter(Departamento departamento);
    void remove(Departamento departamento);
    Departamento buscaPorCod(String NomeDep);
    List<Departamento> buscarDepartamentos();
    
}
