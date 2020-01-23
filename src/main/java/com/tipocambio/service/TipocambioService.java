package com.tipocambio.service;

import com.tipocambio.model.TipocambioRequest;
import com.tipocambio.model.TipocambioResponse;
import com.tipocambio.model.UpdateRequest;
import com.tipocambio.model.UpdateResponse;

import io.reactivex.Single;

public interface TipocambioService {

	Single<TipocambioResponse> findTipocambio(TipocambioRequest request);

	Single<UpdateResponse> saveTipocambio(UpdateRequest request);

}
