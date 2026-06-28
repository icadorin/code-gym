package io.github.israel.exercise.repository;

import io.github.israel.exercise.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsById(Long id);

    boolean existsByEmail(String email);
}
