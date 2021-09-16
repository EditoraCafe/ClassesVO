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

	//métodos getter e setter
	public String getCpf() {
		return cpf;
	}
	//se o espaço do cpf estiver em branco ou nulo ele vai pedir pra informar o cpf, caso tenha sido informado o cpf ele vai guardar o cpf
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
	//se o espaço do endereço estiver em branco ou nulo irá pedir para iformar o endereço, caso tenha sido informado ele irá guardar o endereço
	public void setEndereco(String endereco) {
		if(endereco.equals("") || endereco == null) {
			System.out.println("Informe o endereço: ");
		} else {
			this.endereco = endereco;
		}
		
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}
	//se o espaço do usuario for nulo ele irá pedir para informar o usuário, caso já tenha sido informado o usuário irá guardar o usuario.
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
