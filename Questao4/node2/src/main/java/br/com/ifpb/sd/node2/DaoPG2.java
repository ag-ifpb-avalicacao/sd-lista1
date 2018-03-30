package br.com.ifpb.sd.node2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class DaoPG2 implements Dao {

    private Connection con;
    private final String url;
    private final String user;
    private final String password;
    
    public DaoPG2() {
//        this.url = "jdbc:postgresql://localhost:5432/BD2"; 
        this.url = "jdbc:postgresql://host-banco2:5432/BD2"; 
        this.user = "postgres"; 
        this.password = "12345";
        this.con = ConFactory.getConnection(url, user, password);
    }
    
    @Override
    public void insert(String name) {
        String sql = "INSERT INTO tb_user (name) VALUES (?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            int result = stmt.executeUpdate();
            System.out.println("Adicionado 2: " + result);
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
