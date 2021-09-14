package model.vo;

<<<<<<< Updated upstream
public class LivroVO {
	private String titulo;
	private String genero;
	private int ano;
	private boolean status;
	private AutorVO autor;
=======

public class LivroVO extends UsuarioVO {
	private String titulo;
	private String genero;
	private int ano;    
	private boolean status;
	private AutorVO autor;
	private int id; 
>>>>>>> Stashed changes
		
	// garantindo a integridade dos dados para o titulo
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if(titulo==null) {
            System.out.println("Por favor, reveja essa informação");
		}
		else {
			if(titulo.equals("")) { // perceber diferença de null para vazio 
				System.out.println("Por favor, reveja essa informação, está vazia");	
			}
			else
				this.titulo = titulo;
		}	
	}
		
	
	// garantindo a integridade dos dados para o genero
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		if(genero==null) {
			 System.out.println("Por favor, reveja essa informação");
		}
		else {
			if(genero.equals("")) {
				System.out.println("Por favor, reveja essa informação, está vazia");
			}
			else 
				this.genero = genero;	
		}
	}
	
<<<<<<< Updated upstream
=======
	
>>>>>>> Stashed changes
	// garantindo a integridade dos dados para o ano
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		if(ano>0)
			this.ano = ano;
		else 
			 System.out.println("Por favor, reveja essa informação");
	}
	
<<<<<<< Updated upstream
=======
	
>>>>>>> Stashed changes
	// garantindo a integridade dos dados para o status 
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

	// garantindo a integridade dos dados para o autor 
	public AutorVO getAutor() {
		return autor;
	}
	
	public void setAutor(AutorVO autor) {
		if(autor==null) {
			 System.out.println("Por favor, reveja essa informação");
		}
		else {
		  if(autor.getUsuario().getNome().equals("")) {  // apenas o nome interessa aqui
			  System.out.println("Por favor, reveja essa informação, está vazia");
		  }
		  else
			  this.autor = autor;
		  }
	}
<<<<<<< Updated upstream
}
=======

	// garantindo a integridade dos dados para o id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id>0)
			this.id = id;
		else 
			 System.out.println("Por favor, reveja essa informação");
	}

}
>>>>>>> Stashed changes
