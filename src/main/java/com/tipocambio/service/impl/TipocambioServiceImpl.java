package com.tipocambio.service.impl;

import com.tipocambio.entity.Tipocambio;
import com.tipocambio.model.TipocambioRequest;
import com.tipocambio.model.TipocambioResponse;
import com.tipocambio.model.UpdateRequest;
import com.tipocambio.model.UpdateResponse;
import com.tipocambio.repository.TipocambioRepository;
import com.tipocambio.service.TipocambioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Single;

@Service
public class TipocambioServiceImpl implements TipocambioService {

	@Autowired
	private TipocambioRepository repository;

	@Override
	public Single<TipocambioResponse> findTipocambio(TipocambioRequest request) {
		return Single.just(repository.findByOrigenAndDestino(request.getOrigen(), request.getDestino()))
				.flatMap(opTipocambio -> {
					if (opTipocambio.isPresent()) {
						Tipocambio entity = opTipocambio.get();
						return Single.just(TipocambioResponse.builder().origen(entity.getOrigen())
								.destino(entity.getDestino()).monto(request.getMonto()).cambio(entity.getCambio())
								.value(entity.getCambio().multiply(request.getMonto())).build());
					}
					throw new RuntimeException("Tipocambio not found!");
				});
	}

	@Override
	public Single<UpdateResponse> saveTipocambio(UpdateRequest request) {
		return Single.just(repository.findByOrigenAndDestino(request.getOrigen(), request.getDestino()))
				.flatMap(opTipocambio -> {
					if (opTipocambio.isPresent()) {
						Tipocambio entity = opTipocambio.get();
						entity.setCambio(request.getCambio());
						repository.saveAndFlush(entity);
						return Single.just(new UpdateResponse(Boolean.TRUE));
					}
					return Single.just(new UpdateResponse(Boolean.FALSE));
				});
	}

}
