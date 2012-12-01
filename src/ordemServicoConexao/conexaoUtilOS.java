/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemServicoConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andreas
 */
public class conexaoUtilOS {
    
    
    private static Connection con;

    static{
        String url = "jdbc:mysql://localhost/ordemservico?"
                + "autoReconnect=true";
        String user = "root";
        String password = "gremio";

        try {
            con = DriverManager.getConnection(url, user,
                    password);
        } catch (SQLException ex) {
            System.out.println("Erro de conexão");
            ex.printStackTrace();
        }
    }

    public Connection criarConexao(){
        return con;
    }
    
}
