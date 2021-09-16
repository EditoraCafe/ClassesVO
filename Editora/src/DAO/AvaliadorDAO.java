package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AvaliadorVO;
import VO.UsuarioVO;

public class AvaliadorDAO extends BaseDAO {
	
	public void inserir(AvaliadorVO vo) throws SQLException {
			conn = getConnection();
			String sql = "insert into Avaliador (cpf, endereco, idUsuario) values (?,?,?)";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, vo.getCpf());
				ptst.setString(2, vo.getEndereco());
				ptst.setLong(3, vo.getUsuario().getId());
				ptst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		public void remover(AvaliadorVO vo) throws SQLException {
			conn = getConnection();
			String sql = "delete from Avaliador where id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public List<AvaliadorVO> listar() throws SQLException {
			conn = getConnection();
			String sql = "select * from Avaliador";
			Statement st;
			ResultSet rs;
			List<AvaliadorVO> Avaliadores = new ArrayList<AvaliadorVO>();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					AvaliadorVO vo = new AvaliadorVO(null, null, null);
					vo.setCpf(rs.getString("cpf"));
					vo.setEndereco(rs.getString("endereco"));
					vo.setId(rs.getLong("id"));
					UsuarioDAO user = new UsuarioDAO();
					UsuarioVO uservo = user.getUsuario(rs.getLong("idUsuario"));
					vo.setUsuario(uservo);
					Avaliadores.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Avaliadores;
			
		}


		public void editar(AvaliadorVO vo) throws SQLException {
			conn = getConnection();
			String sql = "update from Avaliador set cpf = ?, endereco = ?, idUsuario = ? where id = ?";
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
