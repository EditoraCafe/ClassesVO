package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	// fazendo a conex�o
	Connection con = null;  
    String url = "jdbc:postgresql://localhost:5432/editora";
    String user = "postgres";
    String senha = "SenhaBd";

    public Connection getConnection(){
        if (con == null){  
            try {
            // se for igual a null tem que cirar a conex�o e invoca esse metodo DriveManager
            con = DriverManager.getConnection(url,user,senha);
                System.out.println("Conectado com sucesso");
            // esse metodo pode disparar uma exeption => comportamento inesperado => pode n�o conectar
            // se alguma n�o der certo java vai avisar que deu errado por meio de uma exeption
            // usar try/catch => se alguma exeption for declarada => codigo vai para esse trecho 
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
            return con; 
        }
        else { 
            return con;
        }
        
    }
    
    
    
    
    


}
