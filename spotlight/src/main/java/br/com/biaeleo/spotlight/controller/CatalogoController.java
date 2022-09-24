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

public class CatalogoController {
    
    private static CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService){
        this.catalogoService = catalogoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> getCatalogo(@PathVariable Long id){
        Optional<Catalogo> catalogoOp = catalogoService.findOne(id);
        if(catalogoOp.isPresent()){
            return ResponseEntity.ok().body(catalogoOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Catalogo>> getCatalogos(){
        List<Catalogo> catalogoList = catalogoService.findAllList();
        if(catalogoList.size() > 0){
            return ResponseEntity.ok().body(catalogoList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Catalogo> update(@RequestBody Catalogo catalogo){
        if(catalogo.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Catalogo id = null");
        }
        catalogo = catalogoService.save(catalogo);
        return ResponseEntity.ok().body(catalogo);
    }

    @PostMapping("/")
    public ResponseEntity<Catalogo> create(@RequestBody Catalogo catalogo){
        if(catalogo.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Catalogo can't exists id.");
        }
        Catalogo result = catalogoService.save(catalogo);
        return ResponseEntity.ok().body(catalogo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogo(@PathVariable Long id){
        catalogoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}