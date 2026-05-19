package br.edu.uninassau.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uninassau.usuario.entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	// Definir querys customizadas caso necessário
	// For example:
	// List<Agendamento> findByDate(Date date);
	// Optional<Agendamento> findById(Long id);
	// void deleteById(Long id);

}
