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

public class SerieController {
    
    private static SerieService serieService;

    public SerieController(SerieService serieService){
        this.serieService = serieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerie(@PathVariable Long id){
        Optional<Serie> serieOp = serieService.findOne(id);
        if(serieOp.isPresent()){
            return ResponseEntity.ok().body(serieOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Serie>> getSeries(){
        List<Serie> serieList = serieService.findAllList();
        if(serieList.size() > 0){
            return ResponseEntity.ok().body(serieList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Serie> update(@RequestBody Serie serie){
        if(serie.getIdSerie() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Serie id = null");
        }
        serie = serieService.save(serie);
        return ResponseEntity.ok().body(serie);
    }

    @PostMapping("/")
    public ResponseEntity<Serie> create(@RequestBody Serie serie){
        if(serie.getIdSerie() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Serie can't exists id.");
        }
        Serie result = serieService.save(serie);
        return ResponseEntity.ok().body(serie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Long id){
        serieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}