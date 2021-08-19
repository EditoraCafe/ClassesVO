package model.vo;

public class UsuarioVO {
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {  //garantir fazendo um if 
		if(login==null)
		{
			// quando cria um objeto => valor null => n�o tem nada dentro 
			// se for nulo e tentar fazer => login.equals("") => vai dar erro 
			// � como se tivesse acessando um metodo de null, de um lugar que n�o existe
			// => n�o tem como acessar => por isso verificar se � nulo 
			// se for null => n�o tem como invocar nenhum metodo
			// come�a a garantir a integridade => fazendo as verifica��es (nos gets n�o precisa)
			//
		}
		else {
			if(login.equals("")) { // diferen�a de null para vazio 
				
			}
			else
				this.login = login;
		}
			
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	} 

}
