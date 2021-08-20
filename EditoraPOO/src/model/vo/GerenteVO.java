package model.vo;

public class GerenteVO {
      private UsuarioVO usuario;

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		if(usuario==null) {
			 System.out.println("Por favor, reveja essa informa��o");
		}
		else {  // testando se os 4 atributos da classe UsuarioVO est�o vazios
			    // se n�o estiverem, vai para o �ltimo else 
			if(usuario.getNome().equals("")) {
				System.out.println("Por favor, reveja essa informa��o, est� vazia");
			}
			if(usuario.getSenha().equals("")) {
				System.out.println("Por favor, reveja essa informa��o, est� vazia");
			}
			if(usuario.getEmail().equals("")) {
				System.out.println("Por favor, reveja essa informa��o, est� vazia");
			}
			if(usuario.getNickname().equals("")) {
				System.out.println("Por favor, reveja essa informa��o, est� vazia");
			}
			else 
				this.usuario = usuario;
		}
	}
}
