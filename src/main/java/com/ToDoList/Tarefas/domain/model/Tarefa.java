package com.ToDoList.Tarefas.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Título não pode ser nulo")
    @Size(min = 1, max = 100, message = "Título deve ter enter 1 a 100 caracteres")
    @Column(name = "titulo",nullable = false, length = 100)

    private String titulo;

    @Size(max = 500, message = "Descrição não pode exceder 500 caracteres")
    @Column(name = "descricao",length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private TarefaStatus status = TarefaStatus.A_FAZER; // valor padrão

    //@NotBlank(message = "Data não pode ser nula")
    @CreationTimestamp
    @Column(name = "data_criar",nullable = false, updatable = false)
    private LocalDateTime dataCriar;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
