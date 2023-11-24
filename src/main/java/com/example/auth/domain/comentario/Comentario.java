package com.example.auth.domain.comentario;

import com.example.auth.domain.evento.Evento;
import jakarta.persistence.*;
import lombok.*;

@Table(name= "comentario")
@Entity(name="comentario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String conteudoComentario;

    @ManyToOne
    @JoinColumn(name="id_evento")
    private Evento evento;

    public Comentario(ComentarioRequestDTO data){
        this.conteudoComentario = data.conteudoComentario();


    }

}
