package com.example.FilmLibrary.repository;
import com.example.FilmLibrary.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository<Filme, Long> {

}