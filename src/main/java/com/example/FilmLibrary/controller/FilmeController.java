package com.example.FilmLibrary.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FilmLibrary.model.Filme;
import com.example.FilmLibrary.repository.FilmeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/filme")
@RestController
public class FilmeController {
    Logger log = LoggerFactory.getLogger(getClass());

    // List<Filme> repository = new ArrayList<>();

    // @RequestMapping(method=RequestMethod.GET , path="/filme")
    // @ResponseBody
    @Autowired
    FilmeRepository repository;

    @GetMapping()
    public List<Filme>index(){
        return repository.findAll();
    }
    // @RequestMapping(method=RequestMethod.POST , path="/filme")
    // @ResponseBody

    // public ResponseEntity<Filme> create(@RequestBody Filme filme){
    //     log.info("cadastrando filme: {}",filme);
    //     repository.add(filme);
    //     return ResponseEntity.status(201).body(filme);
    // }

    // @RequestMapping(method = RequestMethod.GET,path = "/filme/{id}")
    // @ResponseBody
    // public ResponseEntity<Filme> get (@PathVariable() Long id){
    //     log.info("Buscando filme por id {}",id);

    //     var filme = repository
    //     .stream()
    //     .filter(c -> c.id().equals(id))
    //     .findFirst();
    
    // if (filme.isEmpty()) {
    //     return ResponseEntity.status(404).build();
    // }
    //     return ResponseEntity.status(200).body(filme.get());
    // }
}
