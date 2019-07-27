package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.AtchflDtl;
import com.beauate.core.entity.AtchflDtlPK;

@RepositoryRestResource(collectionResourceRel = "atchflDtl", path = "atchflDtl")
public interface AtchflRepository extends JpaRepository<AtchflDtl,AtchflDtlPK>{
}
