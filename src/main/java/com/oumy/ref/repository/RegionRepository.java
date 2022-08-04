package com.oumy.ref.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oumy.ref.model.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long>{

}
