package com.MdinaBus.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.MdinaBus.Models.Pt_ramassage;

public interface Pt_ramassageRepo extends CrudRepository<Pt_ramassage, Long>{
	List<Pt_ramassage> findByIdcircuit(long idC);

}
