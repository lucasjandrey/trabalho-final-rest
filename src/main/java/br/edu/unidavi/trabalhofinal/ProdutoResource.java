package br.edu.unidavi.trabalhofinal;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Link;

public class ProdutoResource extends Resource<Produto> {
	
	public ProdutoResource(Produto produto, Link... links) {
		super(produto, links);
	}
	
}