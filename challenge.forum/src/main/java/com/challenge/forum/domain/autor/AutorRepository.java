package com.challenge.forum.domain.autor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    static UserDetails findByEmail(String subject) {
        return null;
    }
}