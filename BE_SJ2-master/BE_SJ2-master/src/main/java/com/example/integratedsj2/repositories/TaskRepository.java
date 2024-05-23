package com.example.integratedsj2.repositories;

import com.example.integratedsj2.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Integer> {
}
