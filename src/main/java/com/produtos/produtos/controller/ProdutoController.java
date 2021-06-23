package com.produtos.produtos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.produtos.model.Produto;
import com.produtos.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(value="/produto")
	public List<Produto> listarProduto(){
		
		return produtoRepository.findAll();}
	
	
	@GetMapping (value="/produto/{id}")
	public Optional<Produto>listarProdutoUnico(@PathVariable(value ="id") Long id){
		
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping
	@ResponseStatus 
	public Produto salvarProduto(@RequestBody Produto produto){
	
		return produtoRepository.save(produto);
	
	}
	
	@PutMapping
	@ResponseStatus 
	public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable(value ="id") Long id){
	
		produto.setId(id);
		
		return produtoRepository.save(produto);
	
	}
	
	@DeleteMapping(value="/{id}")
	public void deletarProduto(long id) {
		
		produtoRepository.deleteById(id);
	}
	
	
	
	
}
	
