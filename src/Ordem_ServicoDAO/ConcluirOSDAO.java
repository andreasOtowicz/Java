/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordem_ServicoDAO;

import java.util.List;
import ordemservico.model.ConcluirOrdemS;

/**
 *
 * @author andreas
 */
public interface ConcluirOSDAO {
    
    void inserirConcluir(ConcluirOrdemS concluirOS);
     List<ConcluirOrdemS> buscarConcluidas();
    
    
}
