package br.com.biaeleo.spotlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.biaeleo.spotlight.model.Episodio;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
    
}
