package br.com.biaeleo.spotlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.biaeleo.spotlight.model.Agregador;

@Repository
public interface AgregadorRepository extends JpaRepository<Agregador, Long> {
    
}
