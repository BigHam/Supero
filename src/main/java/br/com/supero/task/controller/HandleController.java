/**
 * Programador: Alcir
 * Data: 10/01/2020
 * Finalidade: Tratamento de exceções
 * Demandante: Supero - Desafio de programação
 */
package br.com.supero.task.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class HandleController implements ErrorController  {

    private static Logger logger = LoggerFactory.getLogger(HandleController.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        logger.error("Exceção de segurança", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Erro desconhecido");
        model.addAttribute("errorMessage", errorMessage);
        return "erro";
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public String excecaoPaginaNaoEncontrada(NoHandlerFoundException e, Model model) {
        String errorMessage = e.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "erro";
    }
    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        model.addAttribute("errorMessage", "Página não encontrada");
       return "erro";
    }

	@Override
	public String getErrorPath() {
		return "erro";
	}

}