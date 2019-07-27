package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.MenuMng;

@RepositoryRestResource(collectionResourceRel = "menuMng", path = "menuMng")
public interface MenuMngRepository extends JpaRepository<MenuMng,String>{
}
