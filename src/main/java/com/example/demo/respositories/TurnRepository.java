package com.example.demo.respositories;

import com.example.demo.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
    Optional<Turn> findById(Long id);

}
