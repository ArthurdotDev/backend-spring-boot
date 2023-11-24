package com.example.auth.domain.comentario;

import com.example.auth.domain.evento.Evento;

public record ComentarioResponseDTO(String id, String conteudoComentario, Evento evento) {
    public ComentarioResponseDTO(Comentario comentario){
        this(comentario.getId(), comentario.getConteudoComentario(), comentario.getEvento());
    }
}
