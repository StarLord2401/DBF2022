package br.com.biaeleo.spotlight.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.biaeleo.spotlight.repository.SerieRepository;
import br.com.biaeleo.spotlight.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SerieService{
    private final Logger log = LoggerFactory.getLogger(SerieService.class);
    
    @Autowired
    SerieRepository serieRepository;

    public Serie save(Serie serie) {
        serie = serieRepository.save(serie);
        return serie;
    }

    public Optional<Serie> findOne(Long id){
        log.info("Request to get Serie : {}", id);
        return serieRepository.findById(id);
    }

    public List<Serie> findAllList(){
        log.info("Request to get All Series");
        List<Serie> serieList = serieRepository.findAll();
        log.info("Return of getAllList " + serieList.size());
        return serieList;
    }

    public void delete(Long id){
        log.info("Request to delete Serie : {}", id);
        serieRepository.deleteById(id);
    }

    public List<Serie> saveAll(List<Serie> serieList){
        log.info("Request to save Serie : {}", serieList);
        serieList = serieRepository.saveAll(serieList);
        return serieList;
    }
}
