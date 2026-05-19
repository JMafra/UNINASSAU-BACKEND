package br.edu.uninassau.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uninassau.usuario.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	// Define any custom query methods here if needed
	// For example:
	// List<Endereco> findByCity(String city);

}
