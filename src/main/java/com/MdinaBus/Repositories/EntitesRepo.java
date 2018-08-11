package com.MdinaBus.Repositories;





import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Entite;


@Repository
public interface EntitesRepo extends CrudRepository<Entite, Long> {
	
	
}
