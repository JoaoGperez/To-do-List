package com.labdessoft.roteiro1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labdessoft.roteiro1.entity.Task;
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
