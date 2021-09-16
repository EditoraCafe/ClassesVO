package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	// fazendo a conexão
	Connection con = null;  
    String url = "jdbc:postgresql://localhost:5432/editora";
    String user = "postgres";
    String senha = "SenhaBd";

    public Connection getConnection(){
        if (con == null){  
            try {
            // se for igual a null tem que cirar a conexão e invoca esse metodo DriveManager
            con = DriverManager.getConnection(url,user,senha);
                System.out.println("Conectado com sucesso");
            // esse metodo pode disparar uma exeption => comportamento inesperado => pode não conectar
            // se alguma não der certo java vai avisar que deu errado por meio de uma exeption
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
