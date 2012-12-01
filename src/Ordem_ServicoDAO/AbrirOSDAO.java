/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordem_ServicoDAO;

import java.util.List;
import ordemservico.model.AbrirOrdemS;

/**
 *
 * @author andreas
 */
public interface AbrirOSDAO {
    
     void inserir(AbrirOrdemS abrirOrdem);
    List<AbrirOrdemS> buscarOrdensServicos();
    AbrirOrdemS buscaPodCodigoOS(Long codigoOS);
    
}
