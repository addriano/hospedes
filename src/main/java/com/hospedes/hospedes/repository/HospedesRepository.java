package com.hospedes.hospedes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospedes.hospedes.models.Hospede;

public interface HospedesRepository extends JpaRepository<Hospede, Long>{
	
	Hospede findById(long id);
	
	@Query(	"select u from Hospede u "
			+ "where u.nome 	like :campo "
			+ "or u.documento 	like :campo "
			+ "or u.telefone 	like :campo ")
	List<Hospede> findByNomeDocFone(@Param("campo") String campo);
}
