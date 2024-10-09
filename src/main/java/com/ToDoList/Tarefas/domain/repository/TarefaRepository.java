package com.ToDoList.Tarefas.domain.repository;

import com.ToDoList.Tarefas.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    //Permite Consultas Específicas Sem a Necessidade de Implementar Manualmente no SQL
    //List<Tarefa> findByStatus(String status);

}
