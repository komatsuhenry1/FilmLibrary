package com.example.FilmLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

// import java.util.Random;

//!!!!!!!IMPORTANTE!!!!!!!
//trocar os tipos dos dados se necessario pois iremos pegar os dados de uma
//api existente e ai copiar pra lista da pessoa que está logada


@Data
@Entity
public class Filme{
    @Id
    private Long id;
    private String nome; 
    private String descricao; 
    private String foto; 
    private String genero; 
    private int ano;
    private String duracao; 
    private String elenco;
    private int nota;
}

