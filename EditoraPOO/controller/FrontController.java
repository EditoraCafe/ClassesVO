package controller;

import exceptions.AutenticarExceptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.BaseInterBO;
import model.bo.UsuarioBO;
import model.vo.GerenteVO;
import model.vo.UsuarioVO;
import view.Telas;

public class FrontController {
	
	@FXML private Label erroAut;
	@FXML private TextField logusuario;
	@FXML private TextField senha;
	// ler login e ler senha e chamar classe BO para fazer a autenticação 
	
	private static BaseInterBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
	
	public void autenticar(ActionEvent event) throws Exception{
		UsuarioVO vo = new UsuarioVO();
		vo.setNickname(logusuario.getText());
		vo.setSenha(senha.getText());
		 
		try {
			UsuarioVO autenticado = usuBO.autenticar(vo);
			if (autenticado instanceof GerenteVO) {
				Telas.telaPrincipalGerente(); 
			}
			// colocar if para autor e avaliador 
			else {
				// abrir outras janeas 
			}
		}
		catch(AutenticarExceptions e) { 
			erroAut.setText("Usuario ou senha invalidos");
			erroAut.setVisible(true);
			e.printStackTrace();
		}
	}
	public void logout(ActionEvent event) throws Exception{
		Telas.telaLogin();
	}
}
