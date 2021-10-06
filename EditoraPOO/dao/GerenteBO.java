package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InsertException;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.vo.GerenteVO;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

public class GerenteBO implements BaseInterBO<GerenteVO> {
	BaseInterDAO<GerenteVO> dao = new UsuarioDAO();
	
	public void cadastrar(GerenteVO vo) throws InsertException {
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
	public List<UsuarioVO> buscarPorNome(GerenteVO vo) throws InsertException {
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		GerenteVO vo2 = new GerenteVO();
		try {
			ResultSet rs = dao.listarPorNome(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por nome");
			}
			else {
				rs = dao.listar();
				while(rs.next()) {
					vo2.setNome(rs.getString("nome")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<UsuarioVO> buscarPorId(GerenteVO vo) throws InsertException {
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		GerenteVO vo2 = new GerenteVO();
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

	
	// listar geral
	public List<UsuarioVO> buscar() throws InsertException {  
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		GerenteVO vo2 = new GerenteVO();
		
		try {
			ResultSet rs = dao.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else {
				rs = dao.listar();
				while(rs.next()) { // listar completo 
					vo2.setId(rs.getInt("id"));
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
	public void alterar(GerenteVO vo) throws InsertException {
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
	public void remover(GerenteVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listar();
			if(rs.next()) {
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
	public void buscarPorTitulo(GerenteVO vo) throws InsertException {
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

}
