package br.edu.unidavi.trabalhofinal;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Link;

public class ClienteResource extends Resource<Cliente> {
	
	public ClienteResource(Cliente cliente, Link... links) {
		super(cliente, links);
	}
	
}