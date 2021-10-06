package model.bo;

import java.util.List;

import exceptions.InsertException;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

public interface BaseInterBO<VO> {
     public void cadastrar(VO vo) throws InsertException; // perguntar o pq do erro
     public List<UsuarioVO> buscarPorNome(VO vo) throws InsertException;
     public List<UsuarioVO> buscarPorId(VO vo) throws InsertException;
     public void buscarPorTitulo(VO vo) throws InsertException;
     public void buscarPorEmail(VO vo) throws InsertException; //depois 
     // mais buscar
     public List<UsuarioVO> buscar() throws InsertException;
     public void alterar(VO vo) throws InsertException;
 	public void alterar(LivroVO vo) throws InsertException ;
     public void remover(VO vo) throws InsertException;
     public List<LivroVO> buscarLivro() throws InsertException;
}
