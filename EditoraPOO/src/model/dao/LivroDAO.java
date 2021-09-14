package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.LivroVO;

public class LivroDAO extends BaseDAO {   // extends em livroVO => para usar o UsuarioVO

	
	 // inserir livro 
	 public void inserirLivro(LivroVO vo) {
    	 con = getConnection();
    	 // sql para tabela livro 
    	 String sql = "insert into livro (titulo,genero,ano,autor) values (?,?,?,?)";
    	 PreparedStatement ptst;
    	 try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1,vo.getTitulo());
			ptst.setString(2,vo.getGenero());
			ptst.setInt(3, vo.getAno()); // vai ser uma string? => no bd é yyyy-mm-dd
			ptst.setObject(4, vo.getNome()); // usando herança
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     }
	 
	 
	 // removendo livro pelo id 
     public void removerLivroByid (LivroVO vo) {
   		 con = getConnection();
   		 // não é mais insert => agora é delete 
       	 String sql = "delete from livro where id = ?";
       	 PreparedStatement ptst;
       	 try {
				ptst = con.prepareStatement(sql);
				ptst.setInt(1,vo.getId());  
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
   	  
     }
     
     
     // listar livros mostrando id
     public List<LivroVO> listarLivros(){
   	  // não vai com preparedstatement vai com statement 
   	  con = getConnection();
   	  // o que quer agr no sql é selecionar
   	  String sql = "select * from livro ";
   	  Statement st;
   	  ResultSet rs;
   	  List<LivroVO> livros = new ArrayList<LivroVO>();
   	  
   	  try {
   		  st = con.createStatement();
   		  rs = st.executeQuery(sql);
   		  while (rs.next()) {  // enquanto tiver um proximo dentro do rs vai sair percorrendo
         		// percorrer esse ResultSet => tirar todos os dados de cada elemento dele
   			  LivroVO vo = new LivroVO(); 
   			  vo.setId(rs.getInt("id"));
   			  vo.setTitulo(rs.getString("titulo"));
   			  vo.setGenero(rs.getString("genero"));
   			  vo.setAno(rs.getInt("ano"));
   			  vo.setNome(rs.getString("autor")); //usando a herança => pegando de usuario => setNome
   			  livros.add(vo);
         	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	  return livros;
     }
	
     
     //edição do id do livro pelo titulo
     public void editarIdByTitulo(LivroVO vo){
    	 con = getConnection();
    	 String sql = "update livro set id = ? where titulo =?";
    	 PreparedStatement ptst;
    	 try {
    		 ptst = con.prepareStatement(sql);
    		 ptst.setInt(1, vo.getId());
    		 ptst.setString(2, vo.getTitulo());
    		 ptst.executeUpdate();
    	 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
     }
     
     
     
     // edição do titulo do livro pelo id
     public void editarTituloById(LivroVO vo){
    	 con = getConnection();
    	 String sql = "update livro set titulo = ? where id =?";
    	 PreparedStatement ptst;
    	 try {
    		 ptst = con.prepareStatement(sql);
    		 ptst.setString(1, vo.getTitulo());
    		 ptst.setInt(2, vo.getId());
    		 ptst.executeUpdate();
    	 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
     }
     
     
	 // edição do genero do livro com base no id
     public void editarGeneroById(LivroVO vo) {
   		 con = getConnection(); // getConnection do baseDAO
   		 // não é mais insert => agora é update 
       	 String sql = "update livro set genero = ? where id = ?"; 
       	 PreparedStatement ptst;
       	 try {
				ptst = con.prepareStatement(sql);
				ptst.setString(1,vo.getGenero()); // vai editar somente o genero
				ptst.setInt(2,vo.getId());         
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
     }

     
     // edição do ano do livro com base no id 
     public void editarAnobyId(LivroVO vo) {
   		 con = getConnection(); // getConnection do baseDAO
   		 // não é mais insert => agora é update 
       	 String sql = "update livro set ano = ? where id = ?"; 
       	 PreparedStatement ptst;
       	 try {
				ptst = con.prepareStatement(sql);
				ptst.setInt(1,vo.getAno()); // vai editar somente o ano
				ptst.setInt(2,vo.getId());         
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
     }


     // edição do autor do livro com base no id   
     public void editarAutorbyId(LivroVO vo) {
   		 con = getConnection(); // getConnection do baseDAO
   		 // não é mais insert => agora é update 
       	 String sql = "update livro set autor = ? where id = ?"; 
       	 PreparedStatement ptst;
       	 try {
				ptst = con.prepareStatement(sql);
				ptst.setString(1,vo.getNome()); // herança => usando getNome de UsuarioVO
				ptst.setInt(2,vo.getId());         
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
     }
     
}
