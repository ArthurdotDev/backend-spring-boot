package com.example.auth.domain.evento;

import jakarta.persistence.*;
import lombok.*;
import com.example.auth.domain.comentario.Comentario;

import java.util.ArrayList;
import java.util.List;

@Table(name = "evento")
@Entity(name = "evento")

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String image;
    @Getter
    @Setter
    private String linkEvento;



    @Getter
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;



    public Evento (EventoRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.image = data.image();
        this.linkEvento = data.linkEvento();
        this.comentarios = data.comentarios();
    }


}