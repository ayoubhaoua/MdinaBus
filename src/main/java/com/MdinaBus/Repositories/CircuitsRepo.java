package com.MdinaBus.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;


@Repository
public interface CircuitsRepo extends CrudRepository<Circuit, Long> {

	@Query("select c from  Circuit c where c.id_service=?1")
	List<Circuit> findById_service(@Param("id_service") long id_service);

}
