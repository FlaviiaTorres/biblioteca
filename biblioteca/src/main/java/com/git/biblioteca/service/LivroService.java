package com.git.biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.git.biblioteca.model.User;
import com.git.biblioteca.model.Livro;
import com.git.biblioteca.repository.LivroRepository;
import com.git.biblioteca.repository.UserRepository;

@Service
public class LivroService {
	
	@Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }
    
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Long id) {
    	livroRepository.deleteById(id);
    }

    public Livro reservar(Long livroId, Long userId) {
        Livro livro = findById(livroId);
        User user = userRepository.findById(userId).orElse(null);

        if (livro != null && !livro.isEmprestado() && user != null) {
        	livro.setEmprestadoBy(user);
        	livro.setEmprestado(true);
            return save(livro);
        }
        return null;
    }

    public Livro devolverLivro(Long livroId) {
    	Livro livro = findById(livroId);
        if (livro != null && livro.isEmprestado()) {
            livro.setEmprestadoBy(null);
            livro.setEmprestado(false);
            return save(livro);
        }
        
        return null;
    }

}
