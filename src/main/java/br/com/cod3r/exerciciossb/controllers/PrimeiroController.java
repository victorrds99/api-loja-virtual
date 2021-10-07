package br.com.cod3r.exerciciossb.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@RequestMapping(method = RequestMethod.GET)
	public String Bemvindo() {
		return "Olá boot, Seja Bem vindo ao mundo Spring Boot";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = { "/troxa", "/vacilao" })
	public String Troxa() {
		return "Olá SEU TROXA, Seja Bem vindo ao mundo Spring Boot";
	}
	
	@GetMapping(path = {"/hoje"})
	public String Hoje() {
		Date hj = new Date();
		return hj.toString();
	}
	
	
	
}
