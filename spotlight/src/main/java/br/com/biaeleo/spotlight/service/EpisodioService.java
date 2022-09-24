package br.com.biaeleo.spotlight.service;

import br.com.biaeleo.spotlight.model.*;
import org.springframework.stereotype.Service;
import br.com.biaeleo.spotlight.repository.EpisodioRepository;
import br.com.biaeleo.spotlight.repository.EpisodioIntegranteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EpisodioService{
    private final Logger log = LoggerFactory.getLogger(EpisodioService.class);

    @Autowired
	EpisodioRepository episodioRepository;

    @Autowired
	EpisodioIntegranteRepository episodioIntegranteRepository;

    @Autowired
    IntegranteRepository integranteRepository;

    @Autowired
    CatalogoFilme catalogoFilme;

    @Transactional
    public Episodio save (Episodio episodio){
        List<Integrante> integranteList = episodio.getIntegrantes();
        
        episodio.setIntegrantes(new ArrayList<>());
        episodioRepository.save(episodio);

        for (Integrante integrante : integranteList){
            EpisodioIntegrante episodioIntegrante = new EpisodioIntegrante();
            episodioIntegrante.setEpisodio(episodio);
            episodioIntegrante.setIntegrante(integrante);
            catalogoFilme.setNome(FilmeService.getNome());
            catalogoFilme.setNacionalidade(FilmeService.getNacionalidade());
            catalogoFilme.setDtNascimento(FilmeService.getDtNascimento());

            episodioIntegranteRepository.save(episodioIntegrante);

        }
        return episodio;   
    }

    public Optional<Episodio> findOne(Long id) {
        log.debug("Request to get Episodio : {}", id);
        return episodioRepository.findById(id);
    }

    public List<Episodio> findAllList(){
        log.debug("Request to get All Episodio");
        return episodioRepository.findAll();
    }

    public void delete(Long id) {
        log.debug("Request to delete Episodio : {}", id);
        episodioRepository.deleteById(id);
    }

    public List<Episodio> saveAll(List<Episodio> episodio) {
        log.debug("Request to save Episodio : {}", episodio);
        episodio = episodioRepository.saveAll(episodio);
        return episodio;
    }
}