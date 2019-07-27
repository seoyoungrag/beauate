package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.BeutyUser;

@RepositoryRestResource(collectionResourceRel = "beutyUser", path = "beutyUser")
public interface BeutyUserRepository extends JpaRepository<BeutyUser,String>{
}
