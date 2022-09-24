package br.com.biaeleo.spotlight.service;

import br.com.biaeleo.spotlight.model.*;
import org.springframework.stereotype.Service;
import br.com.biaeleo.spotlight.repository.CatalogoRepository;
import br.com.biaeleo.spotlight.repository.CatalogoFilmeRepository;
import br.com.biaeleo.spotlight.repository.CatalogoSerieRepository;
import br.com.biaeleo.spotlight.repository.FilmeRepository;
import br.com.biaeleo.spotlight.repository.SerieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoService{
    private final Logger log = LoggerFactory.getLogger(CatalogoService.class);

    @Autowired
	CatalogoRepository catalogoRepository;

    @Autowired
	CatalogoFilmeRepository catalogoFilmeRepository;

    @Autowired
    SerieRepository catalogoSerieRepository;

    @Autowired
	CatalogoFilmeRepository filmeRepository;

    @Autowired
    SerieRepository serieRepository;

    @Transactional
    public Catalogo saveFilme (Catalogo catalogo){
        List<Filme> filmeList = catalogo.getFilmes();
        
        catalogo.setFilmes(new ArrayList<>());
        catalogoRepository.save(catalogo);

        for (Filme filme : filmeList){
            CatalogoFilme catalogoFilme = new CatalogoFilme();
            catalogoFilme.setCatalogo(catalogo);
            catalogoFilme.setFilme(filme);
            catalogoFilme.setNome(filme.getNome());
            catalogoFilme.setData(filme.getData());
            catalogoFilme.setDuracao(filme.getDuracao());
            catalogoFilme.setSinopse(filme.getSinopse());

            catalogoFilmeRepository.save(catalogoFilme);

        }
        return catalogo;   
    }

     public Catalogo savSerie (Catalogo catalogo){
        List<Serie> serieList = catalogo.getSeries();
        
        catalogo.setSeries(new ArrayList<>());
        catalogoRepository.save(catalogo);

        for (Serie serie : serieList){
            CatalogoSerie catalogoSerie = new CatalogoSerie();
            catalogoSerie.setCatalogo(catalogo);
            catalogoSerie.setSerie(serie);
            catalogoSerie.setNome(serie.getNome());

            catalogoSerieRepository.save(catalogoSerie);

        }
        return catalogo;   
    }

    public Optional<Catalogo> findOne(Long id) {
        log.debug("Request to get Catalogo : {}", id);
        return catalogoRepository.findById(id);
    }

    public List<Catalogo> findAllList(){
        log.debug("Request to get All Catalogo");
        return catalogoRepository.findAll();
    }

    public void delete(Long id) {
        log.debug("Request to delete Catalogo : {}", id);
        catalogoRepository.deleteById(id);
    }

    public List<Catalogo> saveAll(List<Catalogo> catalogo) {
        log.debug("Request to save Catalogo : {}", catalogo);
        catalogo = catalogoRepository.saveAll(catalogo);
        return catalogo;
    }

    public Catalogo save(Catalogo catalogo) {
        return null;
    }
}