package br.edu.uninassau.usuario.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "grupo_id")
	@JsonIgnore
    private Grupo grupo;
	
	
	@ManyToMany
	@JoinTable(name = "evento_contato",
	joinColumns = @JoinColumn(name = "contato_id"),
	inverseJoinColumns = @JoinColumn(name = "evento_id"))
	private Set<Evento> evento = new HashSet<>();
	
	@OneToOne(mappedBy = "contato")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "contato")
	@JsonIgnore
	private Set<Agendamento> agendamentos = new HashSet<>();
	
	public Set<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(Set<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	 public Set<Evento> getEvento() {
		return evento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEvento(Set<Evento> evento) {
		this.evento = evento;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
