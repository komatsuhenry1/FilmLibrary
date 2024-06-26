package com.example.FilmLibrary.model;

import java.util.ArrayList;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;



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



    @ManyToMany
    @JoinTable(
        name = "filme_ator",
        joinColumns = @JoinColumn(name = "filme_id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id")
    )
    private List<Ator> atores = new ArrayList<>();
}

