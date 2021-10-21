package br.com.cod3r.exerciciossb.models.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	String nome;
	String email; 
	String cpf; 
	String cep; 
	String cidade; 
	String estado;
	
//	@Min(0)
//	private double preco;
//	
//	@Min(0)
//	@Max(1)
//	private double desconto;

	
	public Cliente(int id, String nome, String email, String cpf, String cep, String cidade, String estado) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.cpf = cpf;
	this.cep = cep;
	this.cidade = cidade;
	this.estado = estado;
}

	public Cliente() {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
	

}