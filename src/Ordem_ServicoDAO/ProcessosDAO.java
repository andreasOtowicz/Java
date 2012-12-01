/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordem_ServicoDAO;

import java.util.List;
import ordemservico.model.Processos;

/**
 *
 * @author andreas
 */
public interface ProcessosDAO {
    
    void salvar(Processos processos);
    List<Processos> buscarTodosProcessos();
    
}
