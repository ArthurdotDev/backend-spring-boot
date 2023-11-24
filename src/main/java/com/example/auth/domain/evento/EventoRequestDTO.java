package com.example.auth.domain.evento;

import com.example.auth.domain.comentario.Comentario;
import com.example.auth.domain.comentario.ComentarioRequestDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EventoRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String image,
        @NotBlank
        String linkEvento,

        boolean like,

        List<Comentario> comentarios
) {
}
