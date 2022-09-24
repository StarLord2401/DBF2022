package br.com.biaeleo.spotlight.controller;

import br.com.biaeleo.spotlight.model.*;
import br.com.biaeleo.spotlight.service.*;
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

public class TemporadaController {
    
    private static TemporadaService temporadaService;

    public TemporadaController(TemporadaService temporadaService){
        this.temporadaService = temporadaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temporada> getTemporada(@PathVariable Long id){
        Optional<Temporada> temporadaOp = temporadaService.findOne(id);
        if(temporadaOp.isPresent()){
            return ResponseEntity.ok().body(temporadaOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Temporada>> getTemporadas(){
        List<Temporada> temporadaList = temporadaService.findAllList();
        if(temporadaList.size() > 0){
            return ResponseEntity.ok().body(temporadaList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Temporada> update(@RequestBody Temporada temporada){
        if(temporada.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Temporada id = null");
        }
        temporada = temporadaService.save(temporada);
        return ResponseEntity.ok().body(temporada);
    }

    @PostMapping("/")
    public ResponseEntity<Temporada> create(@RequestBody Temporada temporada){
        if(temporada.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Temporada can't exists id.");
        }
        Temporada result = temporadaService.save(temporada);
        return ResponseEntity.ok().body(temporada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemporada(@PathVariable Long id){
        temporadaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}