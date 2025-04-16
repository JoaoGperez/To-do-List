package com.labdessoft.roteiro1.controller;

import com.labdessoft.roteiro1.entity.Task; 
import com.labdessoft.roteiro1.service.TaskService;
import com.labdessoft.roteiro1.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    @Operation(summary = "Lista todas as tarefas da lista.")
    public ResponseEntity<List<Task>> listAll(){
        try{
            List<Task> taskList = new ArrayList<Task>();
            taskRepository.findAll().forEach(taskList::add);

            if (taskList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/task")
    @Operation(summary = "Cria uma nova tarefa.")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PostMapping("/task/{id}/complete")
    @Operation(summary = "Marca uma tarefa como concluída.")
    public ResponseEntity<Task> completeTask(@PathVariable Long id){
       Task updatedTask = taskService.markTaskAsCompleted(id);
       if (updatedTask != null) {
        return ResponseEntity.ok(updatedTask);
       } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

    }
}
