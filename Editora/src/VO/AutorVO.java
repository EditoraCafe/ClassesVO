package VO;


public class AutorVO {
	//atributos
	private String cpf;
	private String endereco;
	private UsuarioVO usuario;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//construtores do autor
	public AutorVO(String cpf, String endereco, UsuarioVO usuario) {
		this.cpf = cpf;
		this.endereco = endereco;
		this.usuario = usuario;
	}

	//m�todos getter e setter
	public String getCpf() {
		return cpf;
	}
	//se o espa�o do cpf estiver em branco ou nulo ele vai pedir pra informar o cpf, caso tenha sido informado o cpf ele vai guardar o cpf
	public void setCpf(String cpf) {
		if(cpf.equals("") || cpf == null) {
			System.out.println("Informe o cpf: ");
		} else {
			this.cpf = cpf;
		}
		
	}

	public String getEndereco() {
		return endereco;
	}
	//se o espa�o do endere�o estiver em branco ou nulo ir� pedir para iformar o endere�o, caso tenha sido informado ele ir� guardar o endere�o
	public void setEndereco(String endereco) {
		if(endereco.equals("") || endereco == null) {
			System.out.println("Informe o endere�o: ");
		} else {
			this.endereco = endereco;
		}
		
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}
	//se o espa�o do usuario for nulo ele ir� pedir para informar o usu�rio, caso j� tenha sido informado o usu�rio ir� guardar o usuario.
	public void setUsuario(UsuarioVO usuario) {
		if(usuario == null) {
			System.out.println("Informe o usuario: ");
		} else {
			if(!usuario.getEmail().equals("") && !usuario.getNickName().equals("") && 
					!usuario.getNome().equals("") && !usuario.getSenha().equals(""))
				this.usuario = usuario;
			else
				System.out.println("Por favor preenca os campos!");
		}
		
	}

}
