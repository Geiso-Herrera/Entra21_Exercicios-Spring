package br.com.entra21.aula_exercicios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entra21.aula_exercicios.model.Exercicio;
import br.com.entra21.aula_exercicios.model.ItemNivel3;
import br.com.entra21.aula_exercicios.repository.IExercicioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exercicios")
public class ExercicioController {

	@Autowired
	private IExercicioRepository ExercicioRepository;

	private void setMaturidadeNivel3(Exercicio exercicio) {
		final String PATH = "localhost:8080/exemplo";

		exercicio.getLinks(new ArrayList<>());

		exercicio.getLinks().add(new ItemNivel3("GET", PATH));

		exercicio.getLinks().add(new ItemNivel3("GET", PATH + "/" + exercicio.getId()));

		exercicio.getLinks().add(new ItemNivel3("DELETE", PATH + "/" + exercicio.getId()));

		exercicio.getLinks().add(new ItemNivel3("POST", PATH));

		exercicio.getLinks().add(new ItemNivel3("PUT", PATH + "/" + exercicio.getId()));

	}



	

	@GetMapping
	public List<Exercicio> listAll() {

		return ExercicioRepository.findAll();

	}

	@GetMapping("/byage/{age}")
	public List<Exercicio> getByAge(@PathVariable("age") Integer age) {

		return ExercicioRepository.findByAge(age);

	}

	@GetMapping(value = "nomeeidade/{nome}/{idade}")
	public List<Exercicio> getByAgeName(@PathVariable("nome") String nome, @PathVariable("idade") Integer idade) {
		return ExercicioRepository.findByFirstnameAndAge(null, idade);
	}

	@GetMapping(value = "/lessthanequalage/{age}")
	public List<Exercicio> getByAgeLessThanEqual(@PathVariable("age") Integer age) {
		return ExercicioRepository.findByAgeLessThanEqual(age);
	}

	@GetMapping(value = "comecacom/{prefixo}/{age}")
	public List<Exercicio> getStartWith(@PathVariable("prefixo") String sla, @PathVariable("age") Integer anos) {
		return ExercicioRepository.findByLastNameStartWithAndLessThanEqual(sla, anos);
	}

}
