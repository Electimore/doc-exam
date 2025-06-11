package com.example.devops_exam_project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devops_exam_project.Entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
