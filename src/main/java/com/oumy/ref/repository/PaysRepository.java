package com.oumy.ref.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oumy.ref.model.Pays;
@Repository
public interface PaysRepository extends CrudRepository<Pays, Long>{

}
