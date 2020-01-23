package com.tipocambio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class TipocambioRequest {

	@NotEmpty
	private String origen;
	@NotEmpty
	private String destino;
	@NotEmpty
	private BigDecimal monto;

}
