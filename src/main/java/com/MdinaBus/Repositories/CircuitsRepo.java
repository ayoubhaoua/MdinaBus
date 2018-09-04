package com.MdinaBus.Repositories;


import java.util.List;




import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import com.MdinaBus.Models.Circuit;


@Repository
public interface CircuitsRepo extends CrudRepository<Circuit, Long> {

	Circuit findById(long id);
	List<Circuit> findByIdservice(long service);

	



}
