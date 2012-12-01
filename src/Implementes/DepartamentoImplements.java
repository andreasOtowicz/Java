/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementes;

import Ordem_ServicoDAO.DepartamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordemServicoConexao.conexaoUtilOS;
import ordemservico.model.Departamento;

/**
 *
 * @author andreas
 */
public class DepartamentoImplements implements DepartamentoDAO {

    @Override
    public void insert(Departamento departamento) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "insert into departamento value (? , ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, departamento.getCodDepartamento());
            stmt.setString(2, departamento.getNomeDepartamento());
            

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void alter(Departamento departamento) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "update departamento set codDepartamento =  ? "
                + " where NomeDepartamento = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, departamento.getCodDepartamento());
            stmt.setString(2, departamento.getNomeDepartamento());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Departamento departamento) {
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "delete from departamento "
                + "where NomeDepartamento = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setString(1, departamento.getNomeDepartamento());
            
            


            stmt.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public Departamento buscaPorCod(String NomeDep) {

        Departamento departamento = null;
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from departamento "
                + " where NomeDepartamento = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setString(1, NomeDep);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                departamento = new Departamento();                
                departamento.setCodDepartamento(rs.getLong("codDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
            }

        } catch (SQLException ex) {
        }
        return departamento;
    }

    @Override
    public List<Departamento> buscarDepartamentos() {

        List<Departamento> departamentos = new ArrayList<Departamento>();
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from departamento";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Departamento departamento = new Departamento();                
                departamento.setCodDepartamento(rs.getLong("codDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
                //medico.setEndereco(null);
                departamentos.add(departamento);
            }

        } catch (SQLException ex) {
        }
        return departamentos;
    }
}
