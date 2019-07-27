package com.beauate.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.BeutyUser;
import com.beauate.core.entity.PrgrMng;

@RepositoryRestResource(collectionResourceRel = "beutyUser", path = "beutyUser")
public interface BeutyUserRepository extends JpaRepository<BeutyUser,String>{

	Page<PrgrMng> findByUserNmIgnoreCaseContainingAndDelYn(String searchKeyword, String delYn, Pageable pageable);

	Page<PrgrMng> findByEmailAddrIgnoreCaseContainingAndDelYn(String searchKeyword, String delYn,
			Pageable pageable);

	Page<PrgrMng> findByUserNmIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	Page<PrgrMng> findByEmailAddrIgnoreCaseContaining(String searchKeyword, Pageable pageable);
}
