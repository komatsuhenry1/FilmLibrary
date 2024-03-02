package com.example.FilmLibrary.model;

import java.util.Random;

//!!!!!!!IMPORTANTE!!!!!!!
//trocar os tipos dos dados se necessario pois iremos pegar os dados de uma
//api existente e ai copiar pra lista da pessoa que está logada
public record Filme(Long id, String nome, String descricao, String foto, String genero, int ano, String duracao, String elenco, int nota) {

    public Filme(Long id, String nome, String descricao, String foto, String genero, int ano, String duracao, String elenco, int nota) {
    
        var key = (id != null) ? id : Math.abs(new Random().nextLong());
        this.id = key; 
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.elenco = elenco;
        this.nota = nota;
    }
}
