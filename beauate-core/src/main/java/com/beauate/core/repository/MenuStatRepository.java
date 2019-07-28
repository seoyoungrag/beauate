package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.MenuStat;
import com.beauate.core.entity.MenuStatPK;

@RepositoryRestResource(collectionResourceRel = "menuStat", path = "menuStat")
public interface MenuStatRepository extends JpaRepository<MenuStat,MenuStatPK>{
}
