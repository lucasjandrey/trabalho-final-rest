package br.edu.unidavi.trabalhofinal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProdutoRepositoryTest
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProdutoRepository repository;

    @Test
    public void salvarProduto() throws Exception {
        Produto produto = Produto.builder()
            .descricao("Livro")            
            .descricao("Livro Harry Potter")
            .marca("Harry Potter")
            .valor(59.90).build();

        produto = repository.save(produto);

        assertNotNull(produto);
        assertTrue(produto.getId() != null);        
    }

}