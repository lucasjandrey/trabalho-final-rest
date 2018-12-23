package br.edu.unidavi.trabalhofinal;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDescricaoContaining(@Param("descricao") String descricao);

    List<Produto> findByMarca(@Param("marca") String marca);

     @Query("SELECT pr FROM Produto pr, Pedido p, Item i WHERE i.produto_id = pr.id and i.pedido_id = p.numero and TO_CHAR(p.dataCriacao,'YYYY-MM-DD') = :data")
     List<Produto> findByDataCriacao(@Param("data") String data);
}