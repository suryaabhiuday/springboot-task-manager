package com.abhiuday.tasks.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhiuday.tasks.Models.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer>{

    public List<Task> findByTitleContaining(String title);

}
