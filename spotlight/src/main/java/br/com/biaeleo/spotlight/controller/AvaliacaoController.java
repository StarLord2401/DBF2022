package br.com.biaeleo.spotlight.controller;

import br.com.biaeleo.spotlight.model.*;
import br.com.biaeleo.spotlight.service.*;
import br.com.biaeleo.spotlight.repository.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("biaeleo/spotlight")

public class AvaliacaoController {
    
    private static AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> getAvaliacao(@PathVariable Long id){
        Optional<Avaliacao> avaliacaoOp = avaliacaoService.findOne(id);
        if(avaliacaoOp.isPresent()){
            return ResponseEntity.ok().body(avaliacaoOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Avaliacao>> getAvaliacoes(){
        List<Avaliacao> avaliacaoList = avaliacaoService.findAllList();
        if(avaliacaoList.size() > 0){
            return ResponseEntity.ok().body(avaliacaoList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Avaliacao> update(@RequestBody Avaliacao avaliacao){
        if(avaliacao.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Avaliacao id = null");
        }
        avaliacao = avaliacaoService.save(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }

    @PostMapping("/")
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao){
        if(avaliacao.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Avaliacao can't exists id.");
        }
        Avaliacao result = avaliacaoService.save(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long id){
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}