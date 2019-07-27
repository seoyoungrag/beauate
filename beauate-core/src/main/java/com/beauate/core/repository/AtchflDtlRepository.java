package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.Atchfl;

@RepositoryRestResource(collectionResourceRel = "atchfl", path = "atchfl")
public interface AtchflDtlRepository extends JpaRepository<Atchfl,String>{
}
