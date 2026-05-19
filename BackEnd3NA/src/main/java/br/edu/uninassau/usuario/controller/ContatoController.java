package br.edu.uninassau.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uninassau.usuario.entity.Contato;
import br.edu.uninassau.usuario.repository.ContatoRepository;

@RestController
public class ContatoController {
	@Autowired
	ContatoRepository contatoRepository;
	
	@PostMapping("/contato")
	public String saveContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
		return "Contato salvo com sucesso!";
	}

	@GetMapping("/contato")
	public List<Contato> getAllContatos() {
		return contatoRepository.findAll();
	}
	

	@PutMapping("/contato/{id}")
	public String updateContato(@PathVariable Long id, @RequestBody Contato contato) {
		Contato existingContato = contatoRepository.findById(id).orElse(null);
		if (existingContato != null) {
			existingContato.setNome(contato.getNome());
			existingContato.setEmail(contato.getEmail());			
			contatoRepository.save(existingContato);
			return "Contato atualizado com sucesso!";
		} else {
			return "Contato não encontrado!";
		}
	}
	
	@DeleteMapping("/contato/{id}")
	public String deleteContato(@PathVariable Long id) {
		Contato existingContato = contatoRepository.findById(id).orElse(null);
		if (existingContato != null) {
			contatoRepository.delete(existingContato);				
			return "Contato excluído com sucesso!";
		} else {
			return "Contato não encontrado!";
		}
	}

}
