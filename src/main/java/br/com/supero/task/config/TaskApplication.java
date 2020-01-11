/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: configuracoes necessárias para o projeto Spring Boot (ver dependências no POM)
 * Demandante: Supero - Desafio de programação
 */
package br.com.supero.task.config;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("br.com.supero.task.repository")
@ComponentScan("br.com.supero.task")
@EntityScan("br.com.supero.task.model")   
@EnableAutoConfiguration
public class TaskApplication {

	public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		SpringApplication.run(TaskApplication.class, args);
	}

}
