package br.com.supero.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supero.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
