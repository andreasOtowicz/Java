/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementes;

import Ordem_ServicoDAO.AbrirOSDAO;
import Ordem_ServicoDAO.ProcessosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordemServicoConexao.conexaoUtilOS;
import ordemservico.model.Processos;

/**
 *
 * @author andreas
 */
public class ProcessoImplements implements ProcessosDAO {

    @Override
    public void salvar(Processos processos) {

        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "insert into processamento value( ?, ?, ?, ? )";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, processos.getNumeroProcesso());
            stmt.setString(2, processos.getAcaoProcesso());
            stmt.setString(3, processos.getStatusProcesso());
            stmt.setLong(4, processos.getAbrirOrdemS().getNumeroOrdem());


            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Processos> buscarTodosProcessos() {

        AbrirOSDAO abrirOSdao = new AbrirOSImplements();
        List<Processos> processos = new ArrayList<Processos>();
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from processamento";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Processos processo = new Processos();

                processo.setNumeroProcesso(rs.getLong("idProcessamento"));
                processo.setAcaoProcesso(rs.getString("Historico"));
                processo.setStatusProcesso(rs.getString("NomeStatus"));
                processo.setAbrirOrdemS(abrirOSdao.buscaPodCodigoOS(rs.getLong("codOrdemServico")));
                processos.add(processo);
            }

        } catch (SQLException ex) {
        }
        return processos;


    }
}
