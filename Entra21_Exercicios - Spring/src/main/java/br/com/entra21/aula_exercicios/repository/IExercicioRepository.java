package br.com.entra21.aula_exercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entra21.aula_exercicios.model.Exercicio;

@Repository
@EnableJpaRepositories
public interface IExercicioRepository extends JpaRepository<Exercicio, Integer> {
	@Query("SELECT obj FROM Exercicio obj WHERE obj.id =:id")
	Exercicio findByCode(@Param("id") Integer id);

	public List<Exercicio> findByAge(Integer age);

	public List<Exercicio> findByFirstnameAndAge(String name, Integer age);

	public List<Exercicio> findByAgeLessThanEqual(Integer age);

	public List<Exercicio> findByLastNameStartWithAndLessThanEqual(String prefixo, Integer age);

}