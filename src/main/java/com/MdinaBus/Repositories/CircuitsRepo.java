package com.MdinaBus.Repositories;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.Query;
=======
import java.util.Date;

>>>>>>> 7860ae022a52a6b67ad64d4f96d8cdb7345fa65b
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;


@Repository
public interface CircuitsRepo extends CrudRepository<Circuit, Long> {
<<<<<<< HEAD
	@Query("select c from  Circuit c where c.id_service=?1")
	List<Circuit> findById_service(@Param("id_service") long id_service);
=======
	
>>>>>>> 7860ae022a52a6b67ad64d4f96d8cdb7345fa65b

}
