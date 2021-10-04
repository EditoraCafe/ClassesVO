package src.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO> {
	// fazendo a conexão
	private static Connection con = null;  
    private static final String url = "jdbc:postgresql://localhost:5432/editora";
    private static final String user = "postgres";
    private static final String senha = "SenhaBd";

    public Connection getConnection(){
        if (con == null){  
            try {
            con = DriverManager.getConnection(url,user,senha);
                System.out.println("Conectado com sucesso");
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
            return con; 
        }
        else { 
            return con;
        }
        
    }
    
    public static void closeConnection() {
    	if (con != null) {
    		try {
    			con.close();;
    		} catch (SQLException e) {
                e.printStackTrace(); 
            }
    	}
    }
    
    public abstract void inserir(VO vo) throws SQLException;
    public abstract void atualizar(VO vo) throws SQLException;
    public abstract void deletar(VO vo) throws SQLException;

    public abstract ResultSet listarPorId(VO vo) throws SQLException;
    public abstract ResultSet listarPorNome(VO entity) throws SQLException;
    public abstract ResultSet listar() throws SQLException;
    public abstract ResultSet listarPorEmail(VO entity) throws SQLException;
    
}