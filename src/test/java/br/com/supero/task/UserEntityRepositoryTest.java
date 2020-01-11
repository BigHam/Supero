package br.com.supero.task;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.supero.task.repository.TaskRepository;

@DataJpaTest
class UserEntityRepositoryTest {

  @Autowired private TaskRepository taskRepository;

  @Test
  void injectedComponentsAreNotNull(){
    assertThat(taskRepository).isNotNull();
  }
}