package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.GerenteVO;
import model.vo.UsuarioVO;

public class GerenteDAO extends BaseDAO{

	    // achei melhor usar a herança de UsuarioVO => facilitou a manipulação dos metodos 
	   // inserir novo gerente => id inserido automaticamente pelo id 
    public void inserirGerente(GerenteVO vo) {
   	 con = getConnection();
   	 String sql = "insert into gerente (nome,email,senha,nickname) values (?,?,?,?)";
   	 PreparedStatement ptst;
   	 try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEmail());
			ptst.setString(3,vo.getSenha());
			ptst.setString(4,vo.getNickname());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    
    // remover gerente pelo id  
    public void removerGerenteById (GerenteVO vo) {
  		 con = getConnection();
  		 // não é mais insert => agora é delete 
      	 String sql = "delete from gerente where id = ?";
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
    
    
    //listar gerentes mostrando id
    public List<GerenteVO> listarGerentes(){
  	  // vai com statement 
  	  con = getConnection();
  	  // o que quer agr no sql é selecionar
  	  String sql = "select * from gerente ";
  	  Statement st;
  	  ResultSet rs;
  	  List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
  	  
  	  try {
  		  st = con.createStatement();
  		  rs = st.executeQuery(sql);
  		  while (rs.next()) {   
  			  GerenteVO vo = new GerenteVO(); 
  			  vo.setNome(rs.getString("nome"));
  			  vo.setEmail(rs.getString("email"));
  			  vo.setSenha(rs.getString("senha"));
  			  vo.setNickname(rs.getString("nickname"));
  			  vo.setId(rs.getInt("id")); 
  			  gerentes.add(vo);
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  return gerentes;
    }
  	
    
    // editando id do gerente pelo nickname 
    public void editarIdGerenteByNickname(GerenteVO vo) {
		 con = getConnection(); // getConnection do baseDAO
		 // não é mais insert => agora é update 
   	 String sql = "update gerente set id = ? where nickname =?";
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
    
    
    //editando o nome do gerente com base no id 
    public void editarNomeGerenteById(GerenteVO vo) {
  		 con = getConnection(); // getConnection do baseDAO
  		 // não é mais insert => agora é update 
      	 String sql = "update gerente set nome = ? where id = ?"; 
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
    
    
  //editando o email do gerente com base no id 
    public void editarEmailGerenteById(GerenteVO vo) {
  		 con = getConnection(); // getConnection do baseDAO
  		 // não é mais insert => agora é update 
      	 String sql = "update gerente set email = ? where id = ?"; 
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
	
    
    //editando o nickmane do gerente com base no id 
    public void editarNicknameGerenteById(GerenteVO vo) {
  		 con = getConnection(); // getConnection do baseDAO
  		 // não é mais insert => agora é update 
      	 String sql = "update gerente set nickname = ? where id = ?"; 
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
    public void editarSenhaGerenteById(GerenteVO vo) {
  		 con = getConnection(); // getConnection do baseDAO
  		 // não é mais insert => agora é update 
      	 String sql = "update gerente set senha = ? where id = ?"; 
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
