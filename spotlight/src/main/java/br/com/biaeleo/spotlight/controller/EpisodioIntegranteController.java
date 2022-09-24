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

public class EpisodioIntegranteController {
    
    private static EpisodioIntegranteService episodioIntegranteService;

    public EpisodioIntegranteController(EpisodioIntegranteService episodioIntegranteService){
        this.episodioIntegranteService = episodioIntegranteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodioIntegrante> getEpisodioIntegrante(@PathVariable Long id){
        Optional<EpisodioIntegrante> episodioIntegranteOp = episodioIntegranteService.findOne(id);
        if(episodioIntegranteOp.isPresent()){
            return ResponseEntity.ok().body(episodioIntegranteOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<EpisodioIntegrante>> getEpisodioIntegrantes(){
        List<EpisodioIntegrante> episodioIntegranteList = episodioIntegranteService.findAllList();
        if(episodioIntegranteList.size() > 0){
            return ResponseEntity.ok().body(episodioIntegranteList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<EpisodioIntegrante> update(@RequestBody EpisodioIntegrante episodioIntegrante){
        if(episodioIntegrante.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid EpisodioIntegrante id = null");
        }
        episodioIntegrante = episodioIntegranteService.save(episodioIntegrante);
        return ResponseEntity.ok().body(episodioIntegrante);
    }

    @PostMapping("/")
    public ResponseEntity<EpisodioIntegrante> create(@RequestBody EpisodioIntegrante episodioIntegrante){
        if(episodioIntegrante.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New EpisodioIntegrante can't exists id.");
        }
        EpisodioIntegrante result = episodioIntegranteService.save(episodioIntegrante);
        return ResponseEntity.ok().body(episodioIntegrante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisodioIntegrante(@PathVariable Long id){
        episodioIntegranteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}