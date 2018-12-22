package br.edu.unidavi.trabalhofinal;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class ItemResource extends Resource<Item> {
	
	public ItemResource(Item item, Link... links) {
		super(item, links);
	}
}