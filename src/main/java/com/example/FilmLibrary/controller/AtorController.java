package com.example.FilmLibrary.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.FilmLibrary.model.Ator;
import com.example.FilmLibrary.repository.AtorRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("ator")
public class AtorController {
    
    @Autowired
    AtorRepository repository;

    @GetMapping()
    public List<Ator>index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Ator create(@RequestBody Ator ator) {

        log.info("cadastrando ator: {}", ator);
        
        return repository.save(ator);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando ator {}", id);
        verificarSeExisteAtor(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Ator update(@PathVariable Long id, @RequestBody Ator ator) {
        log.info("atualizando Ator com id {} para {}", id, ator);
        verificarSeExisteAtor(id);

        ator.setId(id);

        return repository.save(ator);
    }

    private void verificarSeExisteAtor(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                    NOT_FOUND, 
                                    "id do Ator não encontrado"
                                ));
    }
}
