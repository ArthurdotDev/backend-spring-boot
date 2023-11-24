package com.example.auth.controllers;


import com.example.auth.domain.comentario.Comentario;
import com.example.auth.domain.comentario.ComentarioRequestDTO;
import com.example.auth.domain.evento.Evento;
import com.example.auth.repositories.ComentarioRepository;
import com.example.auth.repositories.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("comentario")
public class ComentarioController {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ComentarioRepository repository;

    @PostMapping("/evento/{eventoId}")
    public ResponseEntity postComentario(@PathVariable String eventoId, @RequestBody ComentarioRequestDTO data)
    {
        Optional<Evento> eventoOpcional = eventoRepository.findById(eventoId);
        if(eventoOpcional.isPresent()){
            Evento evento = eventoOpcional.get();

            Comentario novoComentario =  new Comentario(data);

            novoComentario.setEvento(evento);

            novoComentario = repository.save(novoComentario);
        }

        return ResponseEntity.ok().build();

    }




}
