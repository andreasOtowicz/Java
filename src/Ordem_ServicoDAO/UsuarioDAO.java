/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordem_ServicoDAO;

import java.util.List;
import ordemservico.model.Usuario;

/**
 *
 * @author andreas
 */
public interface UsuarioDAO {
    
    void inserirUser(Usuario usuario);
    void alterarUser(Usuario usuario);
    void removerUser(Usuario usuario);
    Usuario buscaPorId(Long codigoUS);
    List<Usuario> buscarTodos();
    
}
