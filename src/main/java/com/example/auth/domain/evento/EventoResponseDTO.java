package com.example.auth.domain.evento;

import com.example.auth.domain.comentario.Comentario;

import java.util.List;

public record EventoResponseDTO(String id, String nome, String descricao, String image, String linkEvento, List<Comentario> comentario) {
    public EventoResponseDTO(Evento evento){
        this(evento.getId(), evento.getNome(),evento.getDescricao(), evento.getImage(),evento.getLinkEvento(), evento.getComentarios());
    }
}
