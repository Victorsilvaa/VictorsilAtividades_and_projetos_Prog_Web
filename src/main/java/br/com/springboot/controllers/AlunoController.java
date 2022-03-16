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
import br.com.springboot.model.Aluno;
import br.com.springboot.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository repo;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> find(@PathVariable Long id){
       Optional<Aluno> obj = repo.findById(id);
       Aluno user = obj.orElse(null);
       return ResponseEntity.ok().body(user);
    }
    
    @GetMapping()
    public ResponseEntity<List<AlunoDTO>> findAll(){
       List<Aluno> list = repo.findAll();
       List<AlunoDTO> listDTO = list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDTO);
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Aluno obj){
    	obj.setId(null);
    	repo.save(obj);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Long id){
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