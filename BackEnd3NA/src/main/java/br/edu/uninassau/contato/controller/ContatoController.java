package br.edu.uninassau.contato.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import br.edu.uninassau.contato.entity.Contato;

@RestController
public class ContatoController {
	List<Contato> contatos = new ArrayList<Contato>();
	
	@PostMapping("/contato")
	public ResponseEntity<String> criarContato(@RequestBody Contato contato) {
		contatos.add(contato);
		return ResponseEntity.status(201).body("Contato criado com sucesso!");
	}
	

	@GetMapping("/contato")
	public ResponseEntity<List<Contato>> getContato() {
	    return ResponseEntity.ok(contatos);
	}

	
	@PutMapping("/contato/{id}")
	public ResponseEntity<String> putContato(@PathVariable int id, @RequestBody Contato updatedContato) {
	    for (Contato c : contatos) {
	        if (c.getId() == id) {
	            c.setNome(updatedContato.getNome());
	            c.setEmail(updatedContato.getEmail());
	            return ResponseEntity.ok("Contato atualizado com sucesso!");
	        }
	    }
	    return ResponseEntity.notFound().build();
	}

	

	@DeleteMapping("/contato/{id}")
	public ResponseEntity<Void> deleteContato(@PathVariable int id) {
	    for (Contato c : contatos) {
	        if (c.getId() == id) {
	            contatos.remove(c);
	            return ResponseEntity.noContent().build();
	        }
	    }
	    return ResponseEntity.notFound().build();
	}

	

}
