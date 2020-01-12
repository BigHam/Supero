/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: Interface de CRUD para a tabela de Tarefas conforme espeficicação do ORM utilizado
 * Demandante: Supero - Desafio de programação
 */package br.com.supero.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supero.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
