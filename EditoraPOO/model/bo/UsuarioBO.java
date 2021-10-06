package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InsertException;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO> {
	BaseInterDAO<UsuarioVO> dao = new UsuarioDAO();
	
	public void cadastrar(UsuarioVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listarPorEmail(vo); // testar se já tem => não pode email repetido 
			if(rs.next()) {
				throw new InsertException("Impossivel cadastrar, pois já existe usuario cadastrado com esse email");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	// transformar resultset em list 
	// terminar de consertar 
	public List<UsuarioVO> buscarPorNome(UsuarioVO vo) throws InsertException {
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		try {
			ResultSet rs = dao.listarPorNome(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por nome,nome não existe");
			}
			else {
				rs = dao.listarPorNome(vo); //listar geral
				while(rs.next()) {
					UsuarioVO vo2 = new UsuarioVO(); 
					vo2.setId(rs.getInt("id_usu"));
					vo2.setEmail(rs.getString("email"));
					vo2.setNome(rs.getString("nome")); 
					vo2.setSenha(rs.getString("senha")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<UsuarioVO> buscarPorId(UsuarioVO vo) throws InsertException {
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		try {
			ResultSet rs = dao.listarPorId(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por id, id não cadastrado");
			}
			else {
				rs = dao.listarPorId(vo);
				while(rs.next()) {
					UsuarioVO vo2 = new UsuarioVO(); 
					vo2.setId(rs.getInt("id_usu"));
					vo2.setEmail(rs.getString("email"));
					vo2.setNome(rs.getString("nome")); 
					vo2.setSenha(rs.getString("senha")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	
	public List<UsuarioVO> buscar() throws InsertException {  //listar tudo 
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		try {
			ResultSet rs = dao.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar, nada cadastrado");
			}
			else {
				rs = dao.listar();
				while(rs.next()) { // listar completo 
					UsuarioVO vo2 = new UsuarioVO(); 
					vo2.setId(rs.getInt("id_usu"));
					vo2.setNome(rs.getString("nome"));
					vo2.setEmail(rs.getString("email"));
					vo2.setNickname(rs.getString("nickname"));
					vo2.setSenha(rs.getString("senha"));  
					lista.add(vo2);
				}
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
		
	}

	// alterar 
	public void alterar(UsuarioVO vo) throws InsertException { //altera nome com base no id 
		try {
			ResultSet rs = dao.listar();
			if(rs.next()) {
				throw new InsertException("Impossivel alterar");
			}
			else {
				dao.atualizar(vo);
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		
	}

	// remover
	public void remover(UsuarioVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listarPorId(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel deletar");
			}
			else {
				dao.deletar(vo);
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		
	}

	@Override
	public void buscarPorTitulo(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(LivroVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LivroVO> buscarLivro() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscarPorEmail(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}
}
