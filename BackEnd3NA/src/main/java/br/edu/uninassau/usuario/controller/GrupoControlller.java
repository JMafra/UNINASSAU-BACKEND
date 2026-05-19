package br.edu.uninassau.usuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uninassau.usuario.entity.Grupo;
import br.edu.uninassau.usuario.repository.GrupoRepository;

@RestController
public class GrupoControlller {
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@PostMapping("/grupo")
	public String saveGrupo(@RequestBody Grupo grupo) {
		grupoRepository.save(grupo);
		return "Grupo salvo com sucesso!";
	}
	
	@GetMapping("/grupo")
    public List<Grupo> getGrupoAll() {
        return grupoRepository.findAll();
    }

	@GetMapping("/grupo/{id}")
    public Optional<Grupo> getGrupoId(@PathVariable Long id) {
        return grupoRepository.findById(id);
    }

    @PutMapping("/grupo/{id}")
    public String updateGrupo(@PathVariable Long id, @RequestBody Grupo grupo) {
        return grupoRepository.findById(id).map(existingGrupo -> {
            existingGrupo.setDescricao(grupo.getDescricao());
            grupoRepository.save(existingGrupo);
            return "Grupo atualizado com sucesso!";
        }).orElse("Grupo não encontrado!");
    }

    @DeleteMapping("/grupo/{id}")
    public String deleteGrupo(@PathVariable Long id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
            return "Grupo deletado com sucesso!";
        } else {
            return "Grupo não encontrado!";
        }
    }
	

}
