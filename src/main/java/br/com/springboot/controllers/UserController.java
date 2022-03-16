package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repo;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> find(@PathVariable Long id){
       Optional<User> obj = repo.findById(id);
       User user = obj.orElse(null);
       return ResponseEntity.ok().body(user);
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
       List<User> list = repo.findAll();
       return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody User obj){
    	obj.setId(null);
    	repo.save(obj);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody User obj, @PathVariable Long id){
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