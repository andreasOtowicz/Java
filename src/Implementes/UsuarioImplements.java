/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementes;

import Ordem_ServicoDAO.DepartamentoDAO;
import Ordem_ServicoDAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordemServicoConexao.conexaoUtilOS;
import ordemservico.model.Usuario;

/**
 *
 * @author andreas
 */
public class UsuarioImplements implements UsuarioDAO {

    @Override
    public void inserirUser(Usuario usuario) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "insert into usuario value(?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, usuario.getCodigoUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getDepartamento().getNomeDepartamento());
            



            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void alterarUser(Usuario usuario) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "update usuario set CodigoUsuario = ? ,NomeUsuario = ?  "
                + " where NomeDepartamento = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, usuario.getCodigoUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getDepartamento().getNomeDepartamento());



            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void removerUser(Usuario usuario) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "delete from usuario "
                + "where CodigoUsuario = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setLong(1, usuario.getCodigoUsuario());
            
            

            stmt.executeUpdate();
        } catch (SQLException ex) {
           
        }

    }

    @Override
    public Usuario buscaPorId(Long codigoUS) {
        DepartamentoDAO departamentoOS = new DepartamentoImplements();
        Usuario usuario = null;
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from usuario"
                + " where CodigoUsuario = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, codigoUS);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getLong("CodigoUsuario"));
                usuario.setNome(rs.getString("NomeUsuario"));
                usuario.setDepartamento(departamentoOS.buscaPorCod(rs.getString("NomeDepartamento")));


            }

        } catch (SQLException ex) {
        }
        return usuario;

    }

    @Override
    public List<Usuario> buscarTodos() {
        DepartamentoDAO departamentoOS = new DepartamentoImplements();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from usuario";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setCodigoUsuario(rs.getLong("CodigoUsuario"));
                usuario.setNome(rs.getString("NomeUsuario"));
                usuario.setDepartamento(departamentoOS.buscaPorCod(rs.getString("NomeDepartamento")));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
        }
        return usuarios;
    }
}
