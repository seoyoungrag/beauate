package com.beauate.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.PrgrMng;

@RepositoryRestResource(collectionResourceRel = "prgrMng", path = "prgrMng")
public interface PrgrMngRepository extends JpaRepository<PrgrMng, Integer>{
    Page<PrgrMng> findByPrgrNmIgnoreCaseContaining(String prgrNm, Pageable pageable);
    Page<PrgrMng> findByPrgrVriablIgnoreCaseContaining(String prgrVriabl, Pageable pageable);
    Page<PrgrMng> findByPrgrVriablIgnoreCase(String prgrVriabl, Pageable pageable);
    Page<PrgrMng> findByPrgrVriablIgnoreCaseAndPrgrIdNot(String prgrVriabl, int prgrId, Pageable pageable);
}
