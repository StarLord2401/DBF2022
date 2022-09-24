package br.com.biaeleo.spotlight.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.biaeleo.spotlight.repository.AgregadorRepository;
import br.com.biaeleo.spotlight.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AgregadorService{
    private final Logger log = LoggerFactory.getLogger(AgregadorService.class);
    
    @Autowired
    AgregadorRepository agregadorRepository;

    public Agregador save(Agregador agregador) {
        agregador = agregadorRepository.save(agregador);
        return agregador;
    }

    public Optional<Agregador> findOne(Long id){
        log.info("Request to get Agregador : {}", id);
        return agregadorRepository.findById(id);
    }

    public List<Agregador> findAllList(){
        log.info("Request to get All Agregadors");
        List<Agregador> agregadorList = agregadorRepository.findAll();
        log.info("Return of getAllList " + agregadorList.size());
        return agregadorList;
    }

    public void delete(Long id){
        log.info("Request to delete Agregador : {}", id);
        agregadorRepository.deleteById(id);
    }

    public List<Agregador> saveAll(List<Agregador> agregadorList){
        log.info("Request to save Agregador : {}", agregadorList);
        agregadorList = agregadorRepository.saveAll(agregadorList);
        return agregadorList;
    }
}
