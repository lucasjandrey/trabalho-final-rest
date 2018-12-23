package br.edu.unidavi.trabalhofinal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidavi.trabalhofinal.Item;
import br.edu.unidavi.trabalhofinal.ItemRepository;
import br.edu.unidavi.trabalhofinal.ItemResource;
import br.edu.unidavi.trabalhofinal.ItemResourceAssembler;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/itens")
public class ItemRestController {

	@Autowired
	ItemRepository repository;
	
	ItemResourceAssembler assembler = new ItemResourceAssembler();
	
	@PostConstruct
	public void init() {
	
	}
	
	@Secured("ROLE_USER")
    @ApiOperation("Pega os itens pelo número do pedido")
    @GetMapping("/{pedido_id}")
    public ResponseEntity<ItemResource> get(@PathVariable Long pedido_id) {
        Item item = repository.findOne(pedido_id);
        if (item != null) {
            return new ResponseEntity<>(assembler.toResource(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured("ROLE_USER")
    @ApiOperation("Retorna todos os itens")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<ItemResource>> getAll() {
        return new ResponseEntity<>(assembler.toResources(repository.findAll()), HttpStatus.OK);
    }

    @Secured("ROLE_MANAGER")
    @ApiOperation("Insere um item")
    @PostMapping
    public ResponseEntity<ItemResource> create(@RequestBody Item item) {
        item = repository.save(item);
        if (item != null) {
            return new ResponseEntity<>(assembler.toResource(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Secured("ROLE_MANAGER")
    @ApiOperation("Remove os itens pelo id do pedido")
    @DeleteMapping("/{pedido_id}")
    public ResponseEntity<ItemResource> delete(@PathVariable Long pedido_id) {
        Item item = repository.findOne(pedido_id);
        if (item != null) {
            repository.delete(item);
            return new ResponseEntity<>(assembler.toResource(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}