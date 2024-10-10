package com.ToDoList.Tarefas.domain.service;

import com.ToDoList.Tarefas.domain.exception.NegocioException;
import com.ToDoList.Tarefas.domain.model.Tarefa;
import com.ToDoList.Tarefas.domain.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RegistroTarefaService {

    //Aplicação da Regra de Negócio
    private TarefaRepository tarefaRepository;

    @Autowired
    public RegistroTarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscar(Long tarefaId){
        return tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new NegocioException("Tarefa não encontrada"));
    }

    public List<Tarefa> listar(){
        return tarefaRepository.findAll();
    }

}
