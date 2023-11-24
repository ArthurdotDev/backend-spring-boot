package com.example.auth.controllers;

import com.example.auth.domain.comentario.Comentario;
import com.example.auth.domain.evento.Evento;
import com.example.auth.domain.evento.EventoRequestDTO;
import com.example.auth.domain.evento.EventoResponseDTO;

import com.example.auth.repositories.ComentarioRepository;
import com.example.auth.repositories.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("evento")
public class EventoController {

    @Autowired
    EventoRepository repository;

    @Autowired
    ComentarioRepository comentarioRepository;


    @PostMapping
    public ResponseEntity postEvento(@RequestBody @Valid EventoRequestDTO body){

        Evento novoEvento = new Evento(body);

        this.repository.save(novoEvento);

        if(novoEvento.getComentarios() != null){
            for(Comentario comentario : novoEvento.getComentarios()){
                comentario.setEvento(novoEvento);
                comentarioRepository.save(comentario);
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getallEventos(){
        List<EventoResponseDTO> eventoList = this.repository.findAll().stream().map(EventoResponseDTO::new).toList();

        return ResponseEntity.ok(eventoList);
    }
}
