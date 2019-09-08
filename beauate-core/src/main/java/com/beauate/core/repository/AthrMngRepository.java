package com.beauate.core.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.AthrMng;

@RepositoryRestResource(collectionResourceRel = "athrMng", path = "athrMng")
public interface AthrMngRepository extends JpaRepository<AthrMng, Integer>{

	Page<AthrMng> findByAthrCdIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	Page<AthrMng> findByAthrIdIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	Page<AthrMng> findByAthrNmIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	List<AthrMng> findAllByAthrIdNot(int athrId);

	AthrMng findByAthrCdIgnoreCase(String athrCd);

	Long countByMenuMngsMenuSeAndBeutyUsersUserId(String string, int userId);
}
