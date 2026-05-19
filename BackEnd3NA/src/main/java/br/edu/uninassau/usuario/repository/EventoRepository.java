package br.edu.uninassau.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uninassau.usuario.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	// Custom query methods can be defined here if needed
	// For example:
	// List<Evento> findByName(String name);
	// List<Evento> findByDateBetween(Date startDate, Date endDate);

}
