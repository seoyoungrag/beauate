package com.beauate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.CnntLog;
import com.beauate.core.entity.CnntLogPK;

@RepositoryRestResource(collectionResourceRel = "cnntLog", path = "cnntLog")
public interface CnntLogRepository extends JpaRepository<CnntLog,CnntLogPK>{
}
