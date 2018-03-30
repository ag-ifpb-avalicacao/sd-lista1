package br.com.ifpb.sd.node2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class DaoPG1 implements Dao {

    private Connection con;
    private final String url;
    private final String user;
    private final String password;
    
    public DaoPG1() {
//        this.url = "jdbc:postgresql://localhost:5432/BD1"; 
        this.url = "jdbc:postgresql://host-banco1:5432/BD1"; 
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
            System.out.println("Adicionado 1: " + result);
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
