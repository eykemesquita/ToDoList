package com.ToDoList.Tarefas.domain.repository;

import com.ToDoList.Tarefas.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    //Permite Consultas Específicas Sem a Necessidade de Implementar Manualmente no SQL


}
