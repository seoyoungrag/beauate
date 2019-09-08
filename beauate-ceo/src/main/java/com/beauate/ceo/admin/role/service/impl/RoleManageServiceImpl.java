package com.beauate.ceo.admin.role.service.impl;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.role.service.RoleManageService;
import com.beauate.ceo.login.service.LoginVO;
import com.beauate.core.entity.AthrMng;
import com.beauate.core.repository.AthrMngRepository;

@Service("roleService")
public class RoleManageServiceImpl implements RoleManageService {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AthrMngRepository athrMngRepository;

	@Override
	public void selectRoleGroupList(AthrMng roleVO, ModelMap model) throws Exception {
		Pageable pageable = PageRequest.of(roleVO.getPageIndex()-1, roleVO.getPageUnit());
		Page<AthrMng> selectList = null;

		if(!Optional.ofNullable(roleVO.getSearchKeyword()).orElse("").isEmpty() && !Optional.ofNullable(roleVO.getSearchCondition()).orElse("").isEmpty()) {
			if(roleVO.getSearchCondition().equals("athrCd")) {
			    selectList = athrMngRepository.findByAthrCdIgnoreCaseContaining(roleVO.getSearchKeyword(), pageable);
			}else if(roleVO.getSearchCondition().equals("athrId")) {
			    selectList = athrMngRepository.findByAthrIdIgnoreCaseContaining(roleVO.getSearchKeyword(), pageable);
			}else if(roleVO.getSearchCondition().equals("athrNm")) {
				selectList = athrMngRepository.findByAthrNmIgnoreCaseContaining(roleVO.getSearchKeyword(), pageable);
			}
		}else {
			selectList = athrMngRepository.findAll(pageable);
		}
		//총 카운트 
		long cnt = selectList.getTotalElements();
		
		roleVO.setPageIndex(selectList.getPageable().getPageNumber()+1);
		roleVO.setPageSize(selectList.getPageable().getPageSize());
		model.addAttribute("roleGroupList", selectList.getContent());
		model.addAttribute("roleGroupListCnt", cnt);
	}

	@Override
	public void selectRoleGroupDetail(AthrMng roleVO, ModelMap model) throws Exception {
		model.addAttribute("roleVO", athrMngRepository.findById(roleVO.getAthrId()).get());
	}

	@Override
	public void deleteRoleGroup(AthrMng roleVO) throws Exception {
		// myBatis 는 따로 정의 하지 않아도 해당 쿼리의 결과를 int 로 반환 해준다.
		// 사용 되는 예는 삭제, 수정등의 결과 이다.
		Optional<AthrMng> role = athrMngRepository.findById(roleVO.getAthrId());
		if(role.isPresent()) {
			athrMngRepository.delete(role.get());
		}
	}

	@Override
	public void updateRoleGroup(AthrMng roleVO) throws Exception {
		AthrMng role = athrMngRepository.findById(roleVO.getAthrId()).get();
		if(roleVO.getAthrCd()!=null) {
			role.setAthrCd(roleVO.getAthrCd());
		}
		if(roleVO.getAthrNm()!=null) {
			role.setAthrNm(roleVO.getAthrNm());
		}
		if(roleVO.getAthrCn()!=null) {
			role.setAthrCn(roleVO.getAthrCn());
		}
		if(roleVO.getAthrCl()!=null) {
			role.setAthrCl(roleVO.getAthrCl());
		}
		role.setUpdtDe(new Date());
		athrMngRepository.save(role);
		// myBatis 는 따로 정의 하지 않아도 해당 쿼리의 결과를 int 로 반환 해준다.
		// 사용 되는 예는 삭제, 수정등의 결과 이다.
	}

	@Override
	public int insertRoleGroup(AthrMng roleVO) throws Exception {
		return athrMngRepository.save(roleVO) != null ? 1 : 0;
	}

	@Override
	public int selectPortalManageRoleCnt(LoginVO resultVO) {
		Long count = athrMngRepository.countByMenuMngsMenuSeAndBeutyUsersUserId("2", resultVO.getUserId());
		return count.intValue();
	}

}
