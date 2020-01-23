package com.tipocambio.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Tipocambio {

	@Id
	private Integer id;
	private String origen;
	private String destino;
	private BigDecimal cambio;

}
