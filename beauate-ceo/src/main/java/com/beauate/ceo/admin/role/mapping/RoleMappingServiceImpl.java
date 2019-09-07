package com.beauate.ceo.admin.role.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.user.service.UserVO;
import com.beauate.ceo.common.service.PaginationInfo;
import com.beauate.core.entity.AthrMng;

public class RoleMappingServiceImpl {
/*
	@Override
	public List<AthrMng> selectRoleNameOfRoleUser() throws Exception {

		return roleMapper.selectRoleNameOfRoleUser();
	}

	@Override
	public List<AthrMng> selectRoleUserList(AthrMng roleVO) throws Exception {
		
		return roleMapper.selectRoleUserList(roleVO);
	}

	@Override
	public List<AthrMng> selectUserListForUpdateRole(AthrMng roleVO) throws Exception {
		
		return roleMapper.selectUserListForUpdateRole(roleVO);
	}

	@Override
	public int mergeIntoRoleUserMapping(AthrMng roleVO) throws Exception {
		return roleMapper.mergeIntoRoleUserMapping(roleVO);
	}

	@Override
	public void updateRoleUserMapping(AthrMng roleVO) throws Exception {
		String usrId = roleVO.getUsrId();
		if (usrId.indexOf(",") == -1) {
			// 전달 받은 사용자 아이디가 하나인 경우
			roleMapper.updateRoleUserMapping(roleVO);
		} else {
			// 전달 받은 사용자 아이디가 하나가 아니라 여러개가 넘어온 경우
			String[] usrIdArr = usrId.split(",");
			for (int i = 0; i < usrIdArr.length; i++) {
				roleVO.setUsrId(usrIdArr[i]);
				roleMapper.updateRoleUserMapping(roleVO);
			}
		}
	}

	@Override
	public Map<String, Object> selectUserRoleList(UserVO userVO, ModelMap model) throws Exception {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		// 페이징
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(userVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(userVO.getPageUnit());
		paginationInfo.setPageSize(userVO.getPageSize());

		userVO.setFirstIndex(paginationInfo.getFirstRecordIndex() + 1); // +1
		userVO.setLastIndex(paginationInfo.getLastRecordIndex());
		userVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<UserVO> selectList = null;
		
		int cnt = roleMapper.selectUserRoleListCnt(userVO);
		paginationInfo.setTotalRecordCount(cnt);
		
		if (cnt > 0) {

			if (userVO.getSortSubject() == null) {
				userVO.setSortSubject("usrId");
				userVO.setSortDescend("asc");
			}

			selectList = roleMapper.selectUserRoleList(userVO);
		}
		
		rsltMap.put("userRoleList", selectList);
		rsltMap.put("userRoleListCnt", cnt);
		rsltMap.put("paginationInfo", paginationInfo);
		
		return rsltMap;
	}

	@Override
	public Map<String, Object> selectUserRoleForPopup(AthrMng roleVO) throws Exception {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		AthrMng tempUserRole = roleMapper.selectUserRoleForPopup(roleVO);
		List<AthrMng> roleList = roleMapper.selectPossibleRoleForPopup(roleVO);
		
		rsltMap.put("tempRole", tempUserRole);
		rsltMap.put("roleList", roleList);
		
		return rsltMap;
	}

	@Override
	public int updateUserRoleMapping(AthrMng roleVO) throws Exception {
		return roleMapper.updateUserRoleMapping(roleVO);
	}
*/
}
