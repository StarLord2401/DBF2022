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

public class FilmeController {
    
    private static FilmeService filmeService;

    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilme(@PathVariable Long id){
        Optional<Filme> filmeOp = filmeService.findOne(id);
        if(filmeOp.isPresent()){
            return ResponseEntity.ok().body(filmeOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Filme>> getFilmes(){
        List<Filme> filmeList = filmeService.findAllList();
        if(filmeList.size() > 0){
            return ResponseEntity.ok().body(filmeList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Filme> update(@RequestBody Filme filme){
        if(filme.getIdFilme() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Filme id = null");
        }
        filme = filmeService.save(filme);
        return ResponseEntity.ok().body(filme);
    }

    @PostMapping("/")
    public ResponseEntity<Filme> create(@RequestBody Filme filme){
        if(filme.getIdFilme() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Filme can't exists id.");
        }
        Filme result = filmeService.save(filme);
        return ResponseEntity.ok().body(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id){
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}