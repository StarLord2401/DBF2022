package br.com.biaeleo.spotlight.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.biaeleo.spotlight.repository.AvaliacaoRepository;
import br.com.biaeleo.spotlight.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService{
    private final Logger log = LoggerFactory.getLogger(AvaliacaoService.class);
    
    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public Avaliacao save(Avaliacao avaliacao) {
        avaliacao = avaliacaoRepository.save(avaliacao);
        return avaliacao;
    }

    public Optional<Avaliacao> findOne(Long id){
        log.info("Request to get Avaliacao : {}", id);
        return avaliacaoRepository.findById(id);
    }

    public List<Avaliacao> findAllList(){
        log.info("Request to get All Avaliacaos");
        List<Avaliacao> avaliacaoList = avaliacaoRepository.findAll();
        log.info("Return of getAllList " + avaliacaoList.size());
        return avaliacaoList;
    }

    public void delete(Long id){
        log.info("Request to delete Avaliacao : {}", id);
        avaliacaoRepository.deleteById(id);
    }

    public List<Avaliacao> saveAll(List<Avaliacao> avaliacaoList){
        log.info("Request to save Avaliacao : {}", avaliacaoList);
        avaliacaoList = avaliacaoRepository.saveAll(avaliacaoList);
        return avaliacaoList;
    }
}
