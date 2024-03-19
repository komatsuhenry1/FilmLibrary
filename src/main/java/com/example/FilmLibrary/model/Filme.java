package com.example.FilmLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

// import java.util.Random;

//!!!!!!!IMPORTANTE!!!!!!!
//trocar os tipos dos dados se necessario pois iremos pegar os dados de uma
//api existente e ai copiar pra lista da pessoa que está logada


@Data
@Entity
public class Filme{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank 
    private String nome;
    private String descricao; 
    private String foto; 
    private String genero; 
    private int ano;
    private String duracao; 
    
    private String elenco;
    @Positive
    private int nota;
}

