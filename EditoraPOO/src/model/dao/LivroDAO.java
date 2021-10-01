package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.LivroVO;
import model.vo.UsuarioVO;

public class LivroDAO <VO extends LivroVO> extends BaseDAO<VO> {   // extends em livroVO => para usar o UsuarioVO

	
	 // inserir novo usuario // atualizado
    public void inserir(VO vo) throws SQLException  {
   	 String sql = "insert into livro (titulo,genero,ano,autor) values (?,?,?,?)";
   	 PreparedStatement ptst;
   	 try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getTitulo());
			ptst.setString(2,vo.getGenero());
			ptst.setInt(3, vo.getAno()); 
			ptst.setObject(4, vo.getNome()); 
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou, nenhuma linha foi modificada");
			}
	
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getInt(1)); // coloca get long
			}
			else {
				throw new SQLException("A inser��o falhou, nenhum id foi retornado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
   
    
    public void deletar(VO vo) {
       String sql = "delete from livro where id = ?";
  	  PreparedStatement ptst;
      	 try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setInt(1,vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    }    	 
	
    
    public void atualizar(VO vo) {
    	 String sql = "update livro set titulo = ? where id =?";
      	 PreparedStatement ptst;
      	 try {
      		ptst = getConnection().prepareStatement(sql);
      		 ptst.setString(1, vo.getTitulo());
    		 ptst.setInt(2, vo.getId());
    		 ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    } 
     
    
    // atualizado
    public ResultSet listar() {
  	  String sql = "select * from livro";
  	  Statement st;
  	  ResultSet rs = null;
  	  
  	  try {
  		  st =  getConnection().createStatement();
  		  rs = st.executeQuery(sql);
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  	  return rs;
    }
 
     
 // atualizado
    public ResultSet listarPorNome(VO vo) {
  	  String sql = "select * from livro where titulo = ?";
  	  PreparedStatement ptst;
  	  ResultSet rs = null;
  	  
  	  try {
  		  ptst = getConnection().prepareStatement(sql);
  		  ptst.setString(1, vo.getTitulo());
  		  rs = ptst.executeQuery();
  		  
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  	  return rs;
    }


    public ResultSet listarPorId(VO vo) {
  	  String sql = "select * from livro where id = ?";
  	  PreparedStatement ptst;
  	  ResultSet rs = null;
  	  
  	  try {
  		  ptst = getConnection().prepareStatement(sql);
  		  ptst.setInt(1, vo.getId());
  		  System.out.println(ptst);
  		  rs = ptst.executeQuery();
  		  
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  	  return rs;
    }
     
    public ResultSet listarPorGenero(VO vo) {
    	  String sql = "select * from livro where genero = ?";
    	  PreparedStatement ptst;
    	  ResultSet rs = null;
    	  
    	  try {
    		  ptst = getConnection().prepareStatement(sql);
    		  ptst.setString(1, vo.getGenero());
    		  System.out.println(ptst);
    		  rs = ptst.executeQuery();
    		  
    	  } catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}  
    	  return rs;
      }
    
    public ResultSet listarPorAno(VO vo) {
  	  String sql = "select * from livro where ano = ?";
  	  PreparedStatement ptst;
  	  ResultSet rs = null;
  	  
  	  try {
  		  ptst = getConnection().prepareStatement(sql);
  		  ptst.setInt(1, vo.getAno());
  		  System.out.println(ptst);
  		  rs = ptst.executeQuery();
  		  
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  	  return rs;
    }
    
}
