package br.edu.unidavi.trabalhofinal;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.dataCriacao = :data")
	List<Pedido> findByDataCriacao(@Param("data") Date data);

}