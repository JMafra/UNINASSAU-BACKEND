package br.edu.uninassau.contato.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String criarContato(@RequestBody Contato contato) {
		contatos.add(contato);
		return "Contato criado com sucesso!";
	}
	
	@GetMapping("/contato")
	public List<Contato> getContato() {
		return contatos;
	}
	
	@PutMapping("/contato")
	public String putContato() {
		return "Contato atualizado com sucesso!";
	}
	
	@DeleteMapping("/contato")
	public String deleteContato() {
		return "Contato excluido com sucesso!";
	}

}
