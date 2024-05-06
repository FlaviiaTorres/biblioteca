package com.git.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.biblioteca.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
