package br.edu.unidavi.trabalhofinal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Item {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	Integer quantidade;
	Double total;
	Integer pedido_id;
	Integer produto_id;
}