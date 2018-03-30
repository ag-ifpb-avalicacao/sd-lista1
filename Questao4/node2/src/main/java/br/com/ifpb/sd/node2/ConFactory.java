package br.com.ifpb.sd.node2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class ConFactory {
    
    public static Connection getConnection(String url, String user, 
            String password){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
    
}
