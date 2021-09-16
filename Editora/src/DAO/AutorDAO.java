package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutorVO;
import VO.UsuarioVO;

public class AutorDAO extends BaseDAO {
	
	public void inserir(AutorVO vo) throws SQLException {
			conn = getConnection();
			String sql = "insert into Autor (cpf, endereco, idUsuario) values (?,?,?)";
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

		public void remover(AutorVO vo) throws SQLException {
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

		public List<AutorVO> listar() throws SQLException {
			conn = getConnection();
			String sql = "select * from Autor";
			Statement st;
			ResultSet rs;
			List<AutorVO> autores = new ArrayList<AutorVO>();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					AutorVO vo = new AutorVO(null, null, null);
					vo.setCpf(rs.getString("cpf"));
					vo.setEndereco(rs.getString("endereco"));
					vo.setId(rs.getLong("id"));
					UsuarioDAO user = new UsuarioDAO();
					UsuarioVO uservo = user.getUsuario(rs.getLong("idUsuario"));
					vo.setUsuario(uservo);
					autores.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return autores;
			
		}


		public void editar(AutorVO vo) throws SQLException {
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
