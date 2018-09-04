package com.MdinaBus.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Location;


@Repository
public interface LocationRepo extends CrudRepository<Location, Long>{

	List<Location> findByIdentite(long identite);
}
