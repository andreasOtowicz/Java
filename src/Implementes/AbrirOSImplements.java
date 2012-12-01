/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementes;

import Ordem_ServicoDAO.AbrirOSDAO;
import Ordem_ServicoDAO.DepartamentoDAO;
import Ordem_ServicoDAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordemServicoConexao.conexaoUtilOS;
import ordemservico.model.AbrirOrdemS;

/**
 *
 * @author andreas
 */
public class AbrirOSImplements implements AbrirOSDAO {

    @Override
    public void inserir(AbrirOrdemS abrirOrdem) {

        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "insert into ordemservico value(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, abrirOrdem.getNumeroOrdem());
            stmt.setString(2, abrirOrdem.getDataEntrada());
            stmt.setString(3, abrirOrdem.getHoraEntrada());
            stmt.setString(4, abrirOrdem.getProblema());
            stmt.setString(5, abrirOrdem.getPrioridade());
            stmt.setString(6, abrirOrdem.getCaracteristica());
            stmt.setLong(7,abrirOrdem.getUsuario().getCodigoUsuario());
            stmt.setString(8,abrirOrdem.getDepartamento().getNomeDepartamento());            ;

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public List<AbrirOrdemS> buscarOrdensServicos() {

        DepartamentoDAO departamentoOS = new DepartamentoImplements();
        UsuarioDAO usuarioOS = new UsuarioImplements();
        List<AbrirOrdemS> abrirOrdens = new ArrayList<AbrirOrdemS>();
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from ordemservico";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AbrirOrdemS abrirOrdem = new AbrirOrdemS();

                abrirOrdem.setNumeroOrdem(rs.getLong("codOrdemServico"));
                abrirOrdem.setDataEntrada(rs.getString("DataEntrada"));
                abrirOrdem.setHoraEntrada(rs.getString("HoraEntrada"));
                abrirOrdem.setCaracteristica(rs.getString("Caracteristica"));
                abrirOrdem.setPrioridade(rs.getString("Prioridade"));
                abrirOrdem.setProblema(rs.getString("Problema"));
                



                abrirOrdens.add(abrirOrdem);
            }

        } catch (SQLException ex) {
        }
        return abrirOrdens;
    }

    @Override
    public AbrirOrdemS buscaPodCodigoOS(Long codigoOS) {

        UsuarioDAO usuarioOS = new UsuarioImplements();
        DepartamentoDAO departamento = new DepartamentoImplements();
        AbrirOrdemS abrirOrdem = null;
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from ordemservico"
                + " where codordemServico = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, codigoOS);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                abrirOrdem = new AbrirOrdemS();
                abrirOrdem.setNumeroOrdem(rs.getLong("codOrdemServico"));
                abrirOrdem.setDataEntrada(rs.getString("DataEntrada"));
                abrirOrdem.setHoraEntrada(rs.getString("HoraEntrada"));
                abrirOrdem.setCaracteristica(rs.getString("Caracteristica"));
                abrirOrdem.setPrioridade(rs.getString("Prioridade"));
                abrirOrdem.setProblema(rs.getString("Problema"));
                


            }

        } catch (SQLException ex) {
        }
        return abrirOrdem;
    }
}
