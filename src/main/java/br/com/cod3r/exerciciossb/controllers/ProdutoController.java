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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.models.entidades.Produto;
import br.com.cod3r.exerciciossb.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	//Auto Gerar instancia
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//inserir Produtos
	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		
		produtoRepository.save(produto);
		return produto;
	}
	//obter todos os produtos
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	//obter Elementos paginado
	@GetMapping(path = "/pagina/{numeroPagina}/quantidade/{qtdPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
		
		PageRequest pages = PageRequest.of(numeroPagina, qtdPagina);
		return produtoRepository.findAll(pages);
	}
	
	
	//obter só o produto do id selecionado
	@GetMapping(path="/id/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	//alterar os campos
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}	
	
	//deletar os campos do id selecionado
	@DeleteMapping(path = "/{id}")
	public String excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
		return "Exluido com Sucesso!";
	}
	

}
