package com.labdessoft.roteiro1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import com.labdessoft.roteiro1.enums.TaskType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Schema(name = "Todos os detalhes sobre a tarefa.")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Schema(name = "Descrição da tarefa deve possuir pelo menos 10 caracteres.")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres.")
    private String description;

    private Boolean completed;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    private LocalDate dataEntrega;
    private Integer prazoDias;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task [Id =" + id + ", Description " + description + ", Completed = " + completed + "]";
    }
}
