package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InsertException;
import model.dao.AutorDAO;
import model.vo.AutorVO;

public class AutorBO implements BaseInterBO<AutorVO> {
	BaseInterDAO<AutorVO> dao = new AutorDAO();

	public void cadastrar(AutorVO vo) throws InsertException {
		try {
			ResultSet rs = dao.listarPorNome(vo); // testar se já tem => não pode repetir nome
			if(rs.next()) {
				throw new InsertException("Impossivel cadastrar, pois já existe um autor com esse nome");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	@Override
	public List<AutorVO> buscarPorNome(AutorVO vo) throws InsertException { //autor
		List<AutorVO> lista = new ArrayList<AutorVO>();
		AutorVO vo2 = new AutorVO();
		try {
			ResultSet rs = dao.listarPorNome(vo);
			if(!rs.next()) {
				throw new InsertException("Impossivel listar por nome");
			}
			else {
				rs = dao.listar();
				while(rs.next()) {
					vo2.setTitulo(rs.getString("nome")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}

	@Override
	public List<AutorVO> buscarPorId(AutorVO vo) throws InsertException {
		List<AutorVO> lista = new ArrayList<AutorVO>();
		AutorVO vo2 = new AutorVO();
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

	@Override
	public List<AutorVO> buscarAutor() throws InsertException {
		List<AutorVO> lista = new ArrayList<AutorVO>();
		AutorVO vo2 = new AutorVO();
		
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
					vo2.setCpf(rs.getString("cpf"));
					vo2.setEndereco(rs.getString("endereco"));  
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
	public void alterar(AutorVO vo) throws InsertException {
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

	@Override
	public void remover(AutorVO vo) throws InsertException {
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
}
