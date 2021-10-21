package br.com.cod3r.exerciciossb.controllers;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.models.entidades.Cliente;

import br.com.cod3r.exerciciossb.models.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	//Auto Gerar instancia
	@Autowired
	private ClienteRepository clienteRepository;
	
	//inserir Produtos
	@PostMapping
	public @ResponseBody Cliente novoCliente(@RequestBody @Valid Cliente cliente) {
		
		clienteRepository.save(cliente);
		return cliente;
	}
	//obter todos os produtos
	@GetMapping
	public Iterable<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	//obter Elementos paginado
	@GetMapping(path = "/pagina/{numeroPagina}/quantidade/{qtdPagina}")
	public Iterable<Cliente> obterClientesPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
		
		PageRequest pages = PageRequest.of(numeroPagina, qtdPagina);
		return clienteRepository.findAll(pages);
	}
	
	
	//obter só o produto do id selecionado
	@GetMapping(path="/id/{id}")
	public Optional<Cliente> obterClientePorId(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	//alterar os campos
	@PutMapping
	public Cliente alterarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}	
	
	//deletar os campos do id selecionado
	@DeleteMapping(path = "/{id}")
	public String excluirCliente(@PathVariable int id) {
		clienteRepository.deleteById(id);
		return "Exluido com Sucesso!";
	}
	

}
