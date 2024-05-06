package com.git.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
