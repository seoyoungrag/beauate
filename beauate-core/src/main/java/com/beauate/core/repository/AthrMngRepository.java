package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.AthrMng;

@RepositoryRestResource(collectionResourceRel = "athrMng", path = "athrMng")
public interface AthrMngRepository extends JpaRepository<AthrMng,String>{
}
