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

public class EpisodioController {
    
    private static EpisodioService episodioService;

    public EpisodioController(EpisodioService episodioService){
        this.episodioService = episodioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episodio> getEpisodio(@PathVariable Long id){
        Optional<Episodio> episodioOp = episodioService.findOne(id);
        if(episodioOp.isPresent()){
            return ResponseEntity.ok().body(episodioOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Episodio>> getEpisodios(){
        List<Episodio> episodioList = episodioService.findAllList();
        if(episodioList.size() > 0){
            return ResponseEntity.ok().body(episodioList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Episodio> update(@RequestBody Episodio episodio){
        if(episodio.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Episodio id = null");
        }
        episodio = episodioService.save(episodio);
        return ResponseEntity.ok().body(episodio);
    }

    @PostMapping("/")
    public ResponseEntity<Episodio> create(@RequestBody Episodio episodio){
        if(episodio.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Episodio can't exists id.");
        }
        Episodio result = episodioService.save(episodio);
        return ResponseEntity.ok().body(episodio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisodio(@PathVariable Long id){
        episodioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}