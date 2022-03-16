package br.com.springboot.dto;

import br.com.springboot.model.Aluno;

public class AlunoDTO {
	
	private int matricula;
	private String nome;
	
	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno obj) {
		this.matricula = obj.getMatricula();
		this.nome = obj.getNome();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}