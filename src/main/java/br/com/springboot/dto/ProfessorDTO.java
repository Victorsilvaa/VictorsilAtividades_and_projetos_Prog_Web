package br.com.springboot.dto;

import br.com.springboot.model.Professor;

public class ProfessorDTO {
	
		
		private int Horario;
		private String nome_professor;
		
		public ProfessorDTO() {
			
		}
		
		public ProfessorDTO(Professor obj) {
			this.Horario = obj.getHorario();
			this.nome_professor = obj.getNome();
		}

		public int getHorario() {
			return Horario;
		}

		public void setMatricula(int Horario) {
			this.Horario = Horario;
		}

		public String getNome() {
			return nome_professor;
		}

		public void setNome(String nome) {
			this.nome_professor = nome;
		}
		
		

	}


