package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.dto.AlunoDTO;
import br.com.springboot.dto.ProfessorDTO;
import br.com.springboot.model.Aluno;
import br.com.springboot.model.Professor;
import br.com.springboot.repository.AlunoRepository;
import br.com.springboot.repository.ProfessorRepository;

@RestController
@RequestMapping("/nome_professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository repo;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> find(@PathVariable Long id){
       Optional<Professor> obj = repo.findById(id);
       Professor Professor = obj.orElse(null);
       return ResponseEntity.ok().body(Professor);
    }
    
    @GetMapping()
    public ResponseEntity<List<ProfessorDTO>> findAll(){
       List<Professor> list = repo.findAll();
       List<ProfessorDTO> listDTO = list.stream().map(x -> new ProfessorDTO(x)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDTO);
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Professor obj){
    	obj.setId(null);
    	repo.save(obj);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Professor obj, @PathVariable Long id){
    	obj.setId(id);
    	repo.save(obj);
    	return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping(value = "/{id}")
    
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	repo.deleteById(id);
    	return ResponseEntity.noContent().build();
    }
}
