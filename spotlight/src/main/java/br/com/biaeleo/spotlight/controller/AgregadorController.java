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

public class AgregadorController {
    
    private static AgregadorService agregadorService;

    public AgregadorController(AgregadorService agregadorService){
        this.agregadorService = agregadorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agregador> getAgregador(@PathVariable Long id){
        Optional<Agregador> agregadorOp = agregadorService.findOne(id);
        if(agregadorOp.isPresent()){
            return ResponseEntity.ok().body(agregadorOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Agregador>> getAgregadores(){
        List<Agregador> agregadorList = agregadorService.findAllList();
        if(agregadorList.size() > 0){
            return ResponseEntity.ok().body(agregadorList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Agregador> update(@RequestBody Agregador agregador){
        if(agregador.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Agregador id = null");
        }
        agregador = agregadorService.save(agregador);
        return ResponseEntity.ok().body(agregador);
    }

    @PostMapping("/")
    public ResponseEntity<Agregador> create(@RequestBody Agregador agregador){
        if(agregador.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Agregador can't exists id.");
        }
        Agregador result = agregadorService.save(agregador);
        return ResponseEntity.ok().body(agregador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgregador(@PathVariable Long id){
        agregadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}