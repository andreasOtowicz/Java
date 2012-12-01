/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementes;

import Ordem_ServicoDAO.AbrirOSDAO;
import Ordem_ServicoDAO.ConcluirOSDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordemServicoConexao.conexaoUtilOS;
import ordemservico.model.ConcluirOrdemS;

/**
 *
 * @author andreas
 */
public class FecharOSImplements implements ConcluirOSDAO {

    @Override
    public void inserirConcluir(ConcluirOrdemS concluirOS) {

        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "insert into conclusaoos value(? ,?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //Substitui os valores dos "?"1
            stmt.setLong(1, concluirOS.getCodConclusao());
            stmt.setString(2, concluirOS.getDataConclusao());
            stmt.setString(3, concluirOS.getHoraConclusao());
            stmt.setLong(4, concluirOS.getNumeroOrdem().getNumeroOrdem());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }

    @Override
    public List<ConcluirOrdemS> buscarConcluidas() {
        
        AbrirOSDAO abrirOSdao = new AbrirOSImplements();
        List<ConcluirOrdemS> conclusoes = new ArrayList<ConcluirOrdemS>();
        Connection con = new conexaoUtilOS().criarConexao();
        String sql = "select * from conclusaoos";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                ConcluirOrdemS conclusao = new ConcluirOrdemS();

                conclusao.setCodConclusao(rs.getLong("codConclusao"));
                conclusao.setDataConclusao(rs.getString("DataConclusao"));
                conclusao.setHoraConclusao(rs.getString("HoraConclusao"));
                conclusao.setNumeroOrdem(abrirOSdao.buscaPodCodigoOS(rs.getLong("codOrdemServico")));

                conclusoes.add(conclusao);
            }

        } catch (SQLException ex) {
        }
        return conclusoes;
    }
    }
