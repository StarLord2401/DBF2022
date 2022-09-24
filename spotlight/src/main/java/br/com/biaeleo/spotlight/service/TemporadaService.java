package br.com.biaeleo.spotlight.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.biaeleo.spotlight.repository.TemporadaRepository;
import br.com.biaeleo.spotlight.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TemporadaService{
    private final Logger log = LoggerFactory.getLogger(TemporadaService.class);
    
    @Autowired
    TemporadaRepository petRepository;

    public Temporada save(Temporada pet) {
        pet = petRepository.save(pet);
        return pet;
    }

    public Optional<Temporada> findOne(Long id){
        log.info("Request to get Temporada : {}", id);
        return petRepository.findById(id);
    }

    public List<Temporada> findAllList(){
        log.info("Request to get All Temporadas");
        List<Temporada> petList = petRepository.findAll();
        log.info("Return of getAllList " + petList.size());
        return petList;
    }

    public void delete(Long id){
        log.info("Request to delete Temporada : {}", id);
        petRepository.deleteById(id);
    }

    public List<Temporada> saveAll(List<Temporada> petList){
        log.info("Request to save Temporada : {}", petList);
        petList = petRepository.saveAll(petList);
        return petList;
    }
}
