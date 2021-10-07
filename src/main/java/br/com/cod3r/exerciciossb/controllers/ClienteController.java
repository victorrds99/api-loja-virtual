package br.com.cod3r.exerciciossb.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.models.entidades.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping("/pedro" )
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.345.343-10");
	}

	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new  Cliente(id, "Maria", "982.345.343-10");
	}
	@GetMapping
	public Cliente obterClientePorId2(
			@RequestParam(name = "id", defaultValue = "2") int id) {
		return new  Cliente(id, "joão", "982.345.343-10");
	}
	
}
