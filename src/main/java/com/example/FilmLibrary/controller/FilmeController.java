package com.example.FilmLibrary.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.example.FilmLibrary.model.Filme;
import com.example.FilmLibrary.repository.FilmeRepository;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("filme")
public class FilmeController {
    // Logger log = LoggerFactory.getLogger(getClass());
    
    // List<Filme> repository = new ArrayList<>();

    // @RequestMapping(method=RequestMethod.GET , path="/filme")
    // @ResponseBody
    @Autowired
    FilmeRepository repository;

    @GetMapping()
    public List<Filme>index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Filme create(@RequestBody Filme filme) {

        log.info("cadastrando filme: {}", filme);
        
        return repository.save(filme);
    }

    @GetMapping("{id}")
    public ResponseEntity<Filme> get(@PathVariable Long id) {
        log.info("buscando filme com id {}", id);
        return repository   
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando filme {}", id);
        verificarSeExisteFilme(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Filme update(@PathVariable Long id, @RequestBody Filme filme) {
        log.info("atualizando filme com id {} para {}", id, filme);
        verificarSeExisteFilme(id);

        filme.setId(id);

        return repository.save(filme);
    }

    private void verificarSeExisteFilme(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                    NOT_FOUND, 
                                    "id do Filme não encontrado"
                                ));
    }

    
    
}
