package br.edu.uninassau.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.uninassau.usuario.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	//@Query("SELECT c FROM Contato c WHERE c.usuario.id = :usuarioId")
	//List<Contato> findByUsuarioId(@Param("usuarioId") Long usuarioId);

}
