package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO> {
   public void inserir(VO entity) throws SQLException;
   public void atualizar(VO entity) throws SQLException;
   public void deletar(VO entity) throws SQLException;

   public ResultSet listarPorId(VO entity) throws SQLException;
   public ResultSet listarPorNome(VO entity) throws SQLException;
   public ResultSet listar() throws SQLException;
   public ResultSet listarPorEmail(VO entity) throws SQLException;
}
