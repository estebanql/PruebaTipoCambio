package com.tipocambio.controller;

import com.tipocambio.model.TipocambioRequest;
import com.tipocambio.model.TipocambioResponse;
import com.tipocambio.model.UpdateRequest;
import com.tipocambio.model.UpdateResponse;
import com.tipocambio.service.TipocambioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/tipocambio")
public class TipocambioController {

	@Autowired
	private TipocambioService service;

	@PostMapping("/convert")
	public Single<TipocambioResponse> findTipocambio(@RequestBody TipocambioRequest request) {
		return service.findTipocambio(request).subscribeOn(Schedulers.io());
	}

	@PostMapping("/update")
	public Single<UpdateResponse> saveTipocambio(@RequestBody UpdateRequest request) {
		return service.saveTipocambio(request).subscribeOn(Schedulers.io());
	}

}
