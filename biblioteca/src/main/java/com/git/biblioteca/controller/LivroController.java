package com.git.biblioteca.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.git.biblioteca.model.Livro;
import com.git.biblioteca.service.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
	
	@Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivro(@PathVariable Long id) {
        return livroService.findById(id);
    }

    @PostMapping
    public Livro addLivro(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
       livroService.deleteById(id);
    }

    @PostMapping("/{livroId}/reservar/{userId}")
    public ResponseEntity<Livro> reservar(@PathVariable Long livroId, @PathVariable Long userId) {
        Livro livroD = livroService.reservar(livroId, userId);
        if (livroD != null) {
            return ResponseEntity.ok(livroD);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{livroId}/devolver")
    public ResponseEntity<Livro> devolverLivro(@PathVariable Long livroId) {
        Livro devolverLivro = livroService.devolverLivro(livroId);
        if (devolverLivro != null) {
            return ResponseEntity.ok(devolverLivro);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
