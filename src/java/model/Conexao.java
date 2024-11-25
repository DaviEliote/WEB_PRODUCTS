
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;



public class Conexao {
    
       private  static String URL = "jdbc:postgresql://localhost:5432/produtos";
       private  static String USER = "davieliote";
       private  static String PASSWORD = "";
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        
       Class.forName("org.postgresql.Driver");
       return DriverManager.getConnection(URL, USER, PASSWORD);
       
        
    }
    
    
}
