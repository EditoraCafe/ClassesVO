package VO;

import java.util.ArrayList;

public class RelatorioVO {
	//atributos
	private ArrayList<AutorVO> escritores = new ArrayList<>();
	private ArrayList<LivroVO> obras = new ArrayList<>();
	private ArrayList<AvaliadorVO> avaliadores = new ArrayList<>();
	private String periodo;
	
	//construtores
	public RelatorioVO(ArrayList<AutorVO> escritores, ArrayList<LivroVO> obras, ArrayList<AvaliadorVO> avaliadores, String periodo) {
		this.escritores = escritores;
		this.obras = obras;
		this.avaliadores = avaliadores;
		this.periodo = periodo;
	}

	
	//métodos getter e setter
	public ArrayList<AutorVO> getEscritores() {
		return escritores;
	}
	//se for nulo ele irá pedir para informar o escritor, caso já tenha sido informado os escritores, irá guardar a informação dada.
	public void setEscritores(ArrayList<AutorVO> escritores) {
		if (escritores == null) {
			System.out.println("Informe o(s) escritor(es): ");
		} else {
			for (AutorVO autorVO : escritores) {
				if(!autorVO.getCpf().equals("") && !autorVO.getEndereco().equals("") && autorVO.getUsuario() != null) {
					this.escritores = escritores;
				}
			}
			
		}
		
	}
	public ArrayList<LivroVO> getObras() {
		return obras;
	}
	//se for nulo ele irá pedir para informar a obra, caso já tenha sido informado as obras, irá guardar a informação dada.
	public void setObras(ArrayList<LivroVO> obras) {
		if (obras == null) {
			System.out.println("Informe a(s) obra(s): ");
		} else {
			for (LivroVO livroVO : obras) {
				if(livroVO.getAno() != 0 && livroVO.getAutor() != null && !livroVO.getGenero().equals("") 
						&& !livroVO.getTitulo().equals("")) {
					this.obras = obras;
				}
			}
			
		}
		
	}
	public ArrayList<AvaliadorVO> getAvaliadores() {
		return avaliadores;
	}
	//se for nulo ele irá pedir para informar o avaliador, caso já tenha sido informado os avaliadores, irá guardar a informação dada.
	public void setAvaliadores(ArrayList<AvaliadorVO> avaliadores) {
		if (avaliadores == null) {
			System.out.println("Informe o(s) avaliador(es): ");
		} else {
			for (AvaliadorVO avaliadorVO : avaliadores) {
				if(!avaliadorVO.getCpf().equals("") && !avaliadorVO.getEndereco().equals("") && avaliadorVO.getUsuario() != null) {
					this.avaliadores = avaliadores;
				}
			}
			
		}
		
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		if (periodo.equals("") || periodo == null) {
			System.out.println("Informe o período: ");
		} else {
			this.periodo = periodo;
		}
		
	}
	
	
	
}
