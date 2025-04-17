package com.labdessoft.roteiro1.service;

import com.labdessoft.roteiro1.entity.Task;
import com.labdessoft.roteiro1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task markTaskAsCompleted(Long id){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask == null){
            throw new RuntimeException("Tarefa não encontrada.");
        }

        existingTask.setCompleted(updatedTask.getCompleted());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setType(updatedTask.getType());
        existingTask.setDataEntrega(updatedTask.getDataEntrega());
        existingTask.setPrazoDias(updatedTask.getPrazoDias());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null){
            throw  new RuntimeException("Tarefa não encontrada.");
        }
        taskRepository.delete(task);
    }
}
