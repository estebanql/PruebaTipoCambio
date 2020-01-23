package com.tipocambio.repository;

import com.tipocambio.entity.Tipocambio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipocambioRepository extends JpaRepository<Tipocambio, Integer> {

	Optional<Tipocambio> findByOrigenAndDestino(String origen, String destino);

}
