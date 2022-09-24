package br.com.biaeleo.spotlight.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.biaeleo.spotlight.repository.FilmeRepository;
import br.com.biaeleo.spotlight.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FilmeService{
    private final Logger log = LoggerFactory.getLogger(FilmeService.class);
    
    @Autowired
    FilmeRepository filmeRepository;

    public Filme save(Filme filme) {
        filme = filmeRepository.save(filme);
        return filme;
    }

    public Optional<Filme> findOne(Long id){
        log.info("Request to get Filme : {}", id);
        return filmeRepository.findById(id);
    }

    public List<Filme> findAllList(){
        log.info("Request to get All Filmes");
        List<Filme> filmeList = filmeRepository.findAll();
        log.info("Return of getAllList " + filmeList.size());
        return filmeList;
    }

    public void delete(Long id){
        log.info("Request to delete Filme : {}", id);
        filmeRepository.deleteById(id);
    }

    public List<Filme> saveAll(List<Filme> filmeList){
        log.info("Request to save Filme : {}", filmeList);
        filmeList = filmeRepository.saveAll(filmeList);
        return filmeList;
    }

    public static String getNome() {
        return null;
    }

    public static Object getNacionalidade() {
        return null;
    }

    public static Object getDtNascimento() {
        return null;
    }
}
