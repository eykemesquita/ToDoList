package com.ToDoList.Tarefas.domain.api;

import com.ToDoList.Tarefas.domain.exception.NegocioException;
import com.ToDoList.Tarefas.domain.model.Tarefa;
import com.ToDoList.Tarefas.domain.repository.TarefaRepository;
import com.ToDoList.Tarefas.domain.service.RegistroTarefaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final RegistroTarefaService registroTarefaService;

    @GetMapping
    public List<Tarefa> listar(){
        return registroTarefaService.listar();
    }

    @GetMapping("/{tarefaId}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long tarefaId){
        Tarefa achar = registroTarefaService.buscar(tarefaId);
        if (achar != null) {
            return ResponseEntity.ok(achar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody Tarefa tarefa){
        return registroTarefaService.salvar(tarefa);
    }

    @PutMapping("/{tarefaId}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long tarefaId, @RequestBody Tarefa tarefa){
        try {
            Tarefa tarefaAtualizada = registroTarefaService.atualizar(tarefaId, tarefa);
            return ResponseEntity.ok(tarefaAtualizada);
        } catch (NegocioException ex) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{tarefaId}")
    public ResponseEntity<Void> remover(@PathVariable Long tarefaId){
        try {
            registroTarefaService.remover(tarefaId);
            return ResponseEntity.noContent().build();
        } catch (NegocioException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
