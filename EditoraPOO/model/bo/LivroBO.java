package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InsertException;
import model.dao.BaseInterDAO;
import model.dao.LivroDAO;
import model.dao.UsuarioDAO;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

public class LivroBO implements BaseInterBO<UsuarioVO> {
	BaseInterDAO<LivroVO> dao = new LivroDAO();

	public void cadastrar(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listarPorNome(vo); // testar se já tem => não pode repetir nome
			if(rs.next()) {
				throw new InsertException("Impossivel cadastrar, pois já existe um livro com esse nome");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<LivroVO> buscarPorNome(LivroVO vo) throws InsertException { //autor
		List<LivroVO> lista = new ArrayList<LivroVO>();
		LivroVO vo2 = new LivroVO();
		try {
			ResultSet rs = dao.listarPorNome(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por titulo");
			}
			else {
				rs = dao.listar();
				while(rs.next()) {
					vo2.setTitulo(rs.getString("titulo")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<LivroVO> buscarPorId(LivroVO vo) throws InsertException {
		List<LivroVO> lista = new ArrayList<LivroVO>();
		LivroVO vo2 = new LivroVO();
		try {
			ResultSet rs = dao.listarPorId(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por id");
			}
			else {
				rs = dao.listar();
				while(rs.next()) {
					vo2.setId(rs.getInt("id")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	
	
	public List<LivroVO> buscarLivro() throws InsertException {
		List<LivroVO> lista = new ArrayList<LivroVO>();
		LivroVO vo2 = new LivroVO();
		
		try {
			ResultSet rs = dao.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else { 
				rs = dao.listar();
				while(rs.next()) { // listar completo 
					vo2.setId(rs.getInt("id"));
					vo2.setNome(rs.getString("autor"));
					vo2.setAno(rs.getInt("ano"));
					vo2.setTitulo(rs.getString("titulo"));
					vo2.setGenero(rs.getString("genero"));  
					lista.add(vo2);
				}
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
		
	}
	
	@Override
	public void alterar(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listar();
			if(!rs.next()) {
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
	
	public void remover(LivroVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listar();
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
	public List<UsuarioVO> buscarPorNome(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrar(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioVO> buscarPorId(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioVO> buscar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorEmail(UsuarioVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	} 

}
