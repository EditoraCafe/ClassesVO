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
			// quando cria um objeto => valor null => não tem nada dentro 
			// se for nulo e tentar fazer => login.equals("") => vai dar erro 
			// é como se tivesse acessando um metodo de null, de um lugar que não existe
			// => não tem como acessar => por isso verificar se é nulo 
			// se for null => não tem como invocar nenhum metodo
			// começa a garantir a integridade => fazendo as verificações (nos gets não precisa)
			//
		}
		else {
			if(login.equals("")) { // diferença de null para vazio 
				
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
