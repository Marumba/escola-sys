package CRUD.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Conexao 
{
    private static final String URL =  "jdbc:mysql://localhost:3306/escola";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public Conexao () {    } //Possibilita instancias
    
    public static Connection con = null;

    public static Connection Conectar() 
    {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado.");
        } catch ( ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
        return con;
    }
}