package com.hospedes.hospedes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospedes.hospedes.models.CheckIn;

public interface CheckInRepository  extends JpaRepository<CheckIn, Long>{
	
	CheckIn findById(long id);
	
	@Query(	"select u "
			+ "from CheckIn u "
			+ "where data_saida is not null "
			+ "and hospede_id = :hospedeId ")
	List<CheckIn> findNotCheckIn(@Param("hospedeId") long hospedeId);

	@Query(	"select u "
			+ "from CheckIn u "
			+ "where data_saida is null "
			+ "and hospede_id = :hospedeId ")
	List<CheckIn> findInCheckIn(@Param("hospedeId") long hospedeId);

}
