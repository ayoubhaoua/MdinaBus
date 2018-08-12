package com.MdinaBus.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Location;


@Repository
public interface LocationRepo extends CrudRepository<Location, Long>{

	@Query("select l from Location l  where l.id_entite=?1")
	List<Circuit> findById_entite(@Param("id_entite") long id_entite);
}
