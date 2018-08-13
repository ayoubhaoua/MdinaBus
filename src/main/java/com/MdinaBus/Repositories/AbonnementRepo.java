package com.MdinaBus.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Abonnement;

@Repository
public interface AbonnementRepo extends CrudRepository<Abonnement, Long> {

}
