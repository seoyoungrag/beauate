package com.beauate.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.BeutyUser;

@RepositoryRestResource(collectionResourceRel = "beutyUser", path = "beutyUser")
public interface BeutyUserRepository extends JpaRepository<BeutyUser,Integer>{

	Page<BeutyUser> findByUserNmIgnoreCaseContainingAndDelYn(String searchKeyword, String delYn, Pageable pageable);

	Page<BeutyUser> findByEmailAddrIgnoreCaseContainingAndDelYn(String searchKeyword, String delYn,
			Pageable pageable);

	Page<BeutyUser> findByUserNmIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	Page<BeutyUser> findByEmailAddrIgnoreCaseContaining(String searchKeyword, Pageable pageable);

	Optional<BeutyUser> findByEmailAddrAndUserPw(String emailAddr, String userPw);

	List<BeutyUser> findByAthrMngsAthrCd(String athrCd);
	
	List<BeutyUser> findByAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(String athrCd);

	List<BeutyUser> findByUserNmIgnoreCaseContainingAndDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(String searchKeyword, String string,
			String athrCd);

	List<BeutyUser> findByUserIdAndDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(int searchKeyword, String string,
			String athrCd);

	List<BeutyUser> findByDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(String string, String athrCd);
}
