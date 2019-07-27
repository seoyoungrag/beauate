package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.PrgrMng;

@RepositoryRestResource(collectionResourceRel = "prgrMng", path = "prgrMng")
public interface PrgrMngRepository extends JpaRepository<PrgrMng,String>{
}
