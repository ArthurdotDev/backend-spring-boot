package com.example.auth.repositories;

import com.example.auth.domain.comentario.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
