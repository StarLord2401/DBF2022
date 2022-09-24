package br.com.biaeleo.spotlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biaeleo.spotlight.model.CatalogoSerie;
import br.com.biaeleo.spotlight.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    void save(CatalogoSerie catalogoSerie);
    
}
