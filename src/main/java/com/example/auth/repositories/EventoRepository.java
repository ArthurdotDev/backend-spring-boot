package com.example.auth.repositories;

import com.example.auth.domain.evento.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, String> {

    @Override
    Optional<Evento> findById(String id);


}
