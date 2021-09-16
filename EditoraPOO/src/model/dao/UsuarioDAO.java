package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.UsuarioVO;

public class UsuarioDAO extends BaseDAO {
        
	     // inserir novo usuario 
         public void inserirUsuario(UsuarioVO vo) {
        	 con = getConnection();
        	 // codigo sql
        	 String sql = "insert into usuario (nome,email,senha,nickname) values (?,?,?,?)";
        	 PreparedStatement ptst;
        	 try {
				ptst = con.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.setString(2,vo.getEmail());
				ptst.setString(3, vo.getSenha());
				ptst.setString(4, vo.getNickname());
				ptst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
         }
         
         
         // remover usuario pelo id  
          public void removerUsuarioById (UsuarioVO vo) {
        		 con = getConnection();
        		 // não é mais insert => agora é delete 
            	 String sql = "delete from usuario where id = ?";
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
          
          
          //listar usuarios mostrando id
          public List<UsuarioVO> listarUsuarios(){
        	  // vai com statement 
        	  con = getConnection();
        	  // o que quer agr no sql é selecionar
        	  String sql = "select * from usuario ";
        	  Statement st;
        	  ResultSet rs;
        	  List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
        	  
        	  try {
        		  st = con.createStatement();
        		  rs = st.executeQuery(sql);
				   //ResultSet => vem das consultas de bd
	        	   // melhor trabalhar com list do que com resultsSet(proprio de bd)
	        	   // tranformar o resultSet em um list
        		  while (rs.next()) {  // enquanto tiver um proximo dentro do rs vai sair percorrendo
              		// percorrer esse ResultSet => tirar todos os dados de cada elemento dele
        			// e vai colocar dentro de um usuario especifico pra poder adicionar esse usuario em uma lista
        			// vai ler item por item 
        			  UsuarioVO vo = new UsuarioVO(); 
        			  vo.setNome(rs.getString("nome"));
        			  vo.setEmail(rs.getString("email"));
        			  vo.setSenha(rs.getString("senha"));
        			  vo.setNickname(rs.getString("nickname"));
        			  vo.setId(rs.getInt("id")); 
        			  usuarios.add(vo);
              	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  return usuarios;
          }
        	
          
          // editando id do usuario pelo nickname 
          public void editarIdUsuarioByNickname(UsuarioVO vo) {
     		 con = getConnection(); // getConnection do baseDAO
     		 // não é mais insert => agora é update 
         	 String sql = "update usuario set id = ? where nickname =?";
         	 PreparedStatement ptst;
         	 try {
 				ptst = con.prepareStatement(sql);
 				ptst.setInt(1,vo.getId()); // vai receber um id primerio para editar 
 				ptst.setString(2,vo.getNickname());
 				ptst.executeUpdate();
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}  
       }
          
          
          //editando o nome com base no id 
          public void editarNomeUsuarioById(UsuarioVO vo) {
        		 con = getConnection(); // getConnection do baseDAO
        		 // não é mais insert => agora é update 
            	 String sql = "update usuario set nome = ? where id = ?"; 
            	 PreparedStatement ptst;
            	 try {
    				ptst = con.prepareStatement(sql);
    				ptst.setString(1,vo.getNome()); // vai receber um nome primerio para editar 
    				ptst.setInt(2,vo.getId());
    				ptst.executeUpdate();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}  
          }
          
          
          //editando o email com base no id 
          public void editarEmailUsuarioById(UsuarioVO vo) {
        		 con = getConnection(); // getConnection do baseDAO
        		 // não é mais insert => agora é update 
            	 String sql = "update usuario set email = ? where id = ?"; 
            	 PreparedStatement ptst;
            	 try {
    				ptst = con.prepareStatement(sql);
    				ptst.setString(1,vo.getEmail());  // recebe um email para editar 
    				ptst.setInt(2,vo.getId());
    				ptst.executeUpdate();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}  
          }
          
          
          //editando o nickmane com base no id 
          public void editarNicknameUsuarioById(UsuarioVO vo) {
        		 con = getConnection(); // getConnection do baseDAO
        		 // não é mais insert => agora é update 
            	 String sql = "update usuario set nickname = ? where id = ?"; 
            	 PreparedStatement ptst;
            	 try {
    				ptst = con.prepareStatement(sql);
    				ptst.setString(1,vo.getNickname()); 
    				ptst.setInt(2,vo.getId());
    				ptst.executeUpdate();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}  
          }
          
          
          //editando a senha com base no id 
          public void editarSenhaUsuarioById(UsuarioVO vo) {
        		 con = getConnection(); // getConnection do baseDAO
        		 // não é mais insert => agora é update 
            	 String sql = "update usuario set senha = ? where id = ?"; 
            	 PreparedStatement ptst;
            	 try {
    				ptst = con.prepareStatement(sql);
    				ptst.setString(1,vo.getSenha()); 
    				ptst.setInt(2,vo.getId());
    				ptst.executeUpdate();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}  
          }
}

