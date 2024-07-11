package com.challenge.forum.controller;

import com.challenge.forum.domain.autor.Autor;
import com.challenge.forum.domain.autor.AutorDTO;
import com.challenge.forum.domain.autor.AutorRepository;
import com.challenge.forum.domain.autor.AutorResponseDTO;
import com.challenge.forum.domain.topic.TopicResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/autors")
public class AutorController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AutorRepository repository;
    @PostMapping
    public ResponseEntity<AutorResponseDTO> add(@RequestBody @Valid AutorDTO autorDTO, UriComponentsBuilder uriBuilder){
        Autor autor = new Autor(autorDTO);
        autor.setPassword(passwordEncoder.encode(autor.getPassword()));
        repository.save(autor);
        var uri = uriBuilder.path("topics/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorResponseDTO(autor.getName(), autorDTO.email()));
    }
    @SecurityRequirement(name = "bearer-key")
    @GetMapping
    public ResponseEntity<Page<AutorResponseDTO>> list(@PageableDefault(size = 10) Pageable pagination){
        var page = repository.findAll(pagination).map(AutorResponseDTO::new);
        return ResponseEntity.ok(page);
    }
}
