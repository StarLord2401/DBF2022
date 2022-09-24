package br.com.biaeleo.spotlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.biaeleo.spotlight.model.Temporada;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Long> {
    
}
