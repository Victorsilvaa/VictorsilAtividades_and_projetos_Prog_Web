package br.com.springboot.model;

public class Professor {

    
   private Long id;
   private String nome_professor;
   private int Horario;

   public Professor(Long id,String nome,int carga){
       this.id = id;
       this.nome_professor = nome;
       this.Horario = carga;
   }

   public Long getId(){
       return this.id;
   }

   public String getNome(){
       return this.nome_professor;
   }

   public int getHorario(){
       return this.Horario;
   }

   public void setId(Long novoId){
       this.id = novoId;
   }

   public void setNome(String novoNome){
       this.nome_professor = novoNome;
   }

   public void setHorario(int novaCarga){
       this.Horario = novaCarga;
   }

   @Override
   public String toString(){
       String saida = "ID : "+this.id+System.lineSeparator()+"Nome: "+ this.nome_professor + System.lineSeparator()+"Carga Horaria: "+this.Horario+System.lineSeparator();
       
   return saida;

   }


    
}
