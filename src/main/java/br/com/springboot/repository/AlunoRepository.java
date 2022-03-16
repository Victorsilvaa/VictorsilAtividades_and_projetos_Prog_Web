package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}