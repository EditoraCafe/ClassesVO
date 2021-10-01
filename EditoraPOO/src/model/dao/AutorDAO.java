package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutorVO;
import VO.UsuarioVO;

public class AutorDAO extends BaseDAO<AutorVO> {
	@Override
	public void inserir(AutorVO vo) throws SQLException {
		try {
			super.inserir(vo);
			conn = getConnection();
			String sql = "insert into Autor (cpf, endereco, idUsuario) values (?,?,?)";
			PreparedStatement ptst;
			ptst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getEndereco());
			ptst.setLong(3, vo.getUsuario().getId());
			int affectedRows = ptst.executeUpdate();
			if(affectedRows == 0) {
				throws new SQLException('A inserção falhou!');
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()){
				vo.setIDFunc(generatedKeys.getLong(1));
			} else {
				throws new SQLException('A inserção falhou!');
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public void remover(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from Autor where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "select * from Autor";
		PreparedStatement st;
		ResultSet rs = null;
			
		try {
			st = conn.createStatement(sql);
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
	}

	@Override
	public void editar(VO vo) throws SQLException {
			conn = getConnection();
			String sql = "update from Autor set cpf = ?, endereco = ?, idUsuario = ? where id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, vo.getCpf());
				ptst.setString(2, vo.getEndereco());
				ptst.setLong(3, vo.getUsuario().getId());
				ptst.setLong(5, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


}
