package com.tipocambio.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipocambioResponse {

	private String origen;
	private String destino;
	private BigDecimal monto;
	private BigDecimal cambio;
	private BigDecimal value;

}
