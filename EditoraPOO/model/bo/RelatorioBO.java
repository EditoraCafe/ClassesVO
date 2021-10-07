package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InsertException;
import model.dao.RelatorioDAO;
import model.vo.RelatorioVO;
import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class RelatorioBO implements BaseInterBO<RelatorioVO> {
	BaseInterDAO<AutorVO> dao1 = new AutorDAO();
	BaseInterDAO<AvaliadorVO> dao2 = new AvaliadorDAO();
	BaseInterDAO<LivroVO> dao3 = new LivroDAO();

	public List<RelatorioVO> gerarRelatorioDia(RelatorioVO vo) throws InsertException {
		List<RelatorioVO> lista = new ArrayList<RelatorioVO>();
		RelatorioVO vo2 = new RelatorioVO();
		try {
			ResultSet rs =+ dao1.listarDia();
			rs =+ dao2.listar();
			rs =+ dao3.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else {
				rs =+ dao1.listar();
				rs =+ dao2.listar();
				rs =+ dao3.listar();
				while(rs.next()) {
					vo2.setAutor(rs.getAutor("autor")); 
					vo2.setAvaliador(rs.getAvaliador("avaliador")); 
					vo2.setLivro(rs.getLivro("livro")); 
					vo2.setPeriodo(rs.getPeriodo("periodo")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<RelatorioVO> gerarRelatorioSemanal(RelatorioVO vo) throws InsertException {
		List<RelatorioVO> lista = new ArrayList<RelatorioVO>();
		RelatorioVO vo2 = new RelatorioVO();
		try {
			ResultSet rs =+ dao1.listarSemanal();
			rs =+ dao2.listar();
			rs =+ dao3.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else {
				rs =+ dao1.listar();
				rs =+ dao2.listar();
				rs =+ dao3.listar();
				while(rs.next()) {
					vo2.setAutor(rs.getAutor("autor")); 
					vo2.setAvaliador(rs.getAvaliador("avaliador")); 
					vo2.setLivro(rs.getLivro("livro")); 
					vo2.setPeriodo(rs.getPeriodo("periodo")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<RelatorioVO> gerarRelatorioQuinzenal(RelatorioVO vo) throws InsertException {
		List<RelatorioVO> lista = new ArrayList<RelatorioVO>();
		RelatorioVO vo2 = new RelatorioVO();
		try {
			ResultSet rs =+ dao1.listarQuinzenal();
			rs =+ dao2.listar();
			rs =+ dao3.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else {
				rs =+ dao1.listar();
				rs =+ dao2.listar();
				rs =+ dao3.listar();
				while(rs.next()) {
					vo2.setAutor(rs.getAutor("autor")); 
					vo2.setAvaliador(rs.getAvaliador("avaliador")); 
					vo2.setLivro(rs.getLivro("livro")); 
					vo2.setPeriodo(rs.getPeriodo("periodo")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	

	public List<RelatorioVO> gerarRelatorioMensal(RelatorioVO vo) throws InsertException {
		List<RelatorioVO> lista = new ArrayList<RelatorioVO>();
		RelatorioVO vo2 = new RelatorioVO();
		try {
			ResultSet rs =+ dao1.listarMensal();
			rs =+ dao2.listar();
			rs =+ dao3.listar();
			if(!rs.next()) {
				throw new InsertException("Impossivel listar");
			}
			else {
				rs =+ dao1.listar();
				rs =+ dao2.listar();
				rs =+ dao3.listar();
				while(rs.next()) {
					vo2.setAutor(rs.getAutor("autor")); 
					vo2.setAvaliador(rs.getAvaliador("avaliador")); 
					vo2.setLivro(rs.getLivro("livro")); 
					vo2.setPeriodo(rs.getPeriodo("periodo")); 
					lista.add(vo2);
				}
			}
		} catch(SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return lista;
	}	


}
