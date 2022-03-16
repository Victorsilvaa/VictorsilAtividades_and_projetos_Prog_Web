package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.springboot.model.Professor;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}