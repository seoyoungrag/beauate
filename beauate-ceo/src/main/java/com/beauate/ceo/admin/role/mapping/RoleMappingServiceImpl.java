package com.beauate.ceo.admin.role.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;
import com.beauate.core.repository.AthrMngRepository;
import com.beauate.core.repository.BeutyUserRepository;

@Service("roleMappingService")
public class RoleMappingServiceImpl implements RoleMappingService{
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AthrMngRepository athrMngRepository;
	@Autowired
	private BeutyUserRepository beutyUserRepository;

	@Override
	public List<AthrMng> selectRoleNameOfRoleUser() throws Exception {
		return athrMngRepository.findAll();
	}

	@Override
	public List<BeutyUser> selectRoleUserList(AthrMng roleVO) throws Exception {
		return beutyUserRepository.findByAthrMngsAthrCd(roleVO.getAthrCd());
	}

	@Override
	public List<BeutyUser> selectUserListForUpdateRole(AthrMng roleVO) throws Exception {
		List<BeutyUser> selectList = null;
		if(roleVO.getSearchKeyword()!=null && roleVO.getSearchCondition()!=null) {
			if(roleVO.getSearchCondition().equals("userNm")) {
			    selectList = beutyUserRepository.findByUserNmIgnoreCaseContainingAndDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(roleVO.getSearchKeyword(), "N", roleVO.getAthrCd());
			}else if(roleVO.getSearchCondition().equals("userId")) {
			    selectList = beutyUserRepository.findByUserIdAndDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(Integer.parseInt(roleVO.getSearchKeyword()), "N", roleVO.getAthrCd());
			}else {
				selectList = beutyUserRepository.findByDelYnAndAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull("N", roleVO.getAthrCd());
			}
		}else {
			selectList = beutyUserRepository.findByAthrMngsAthrCdNotOrAthrMngsAthrCdIsNull(roleVO.getAthrCd());
		}
		return selectList;
	}

	@Override
	public int mergeIntoRoleUserMapping(BeutyUser userVO) throws Exception {
		BeutyUser user = beutyUserRepository.findById(userVO.getUserId()).get();
		user.setAthrMngs(userVO.getAthrMngs());
		beutyUserRepository.save(user);
		return 1;
	}

	@Override
	public void updateRoleUserMapping(AthrMng roleVO) throws Exception {

		String userIds = roleVO.getUserIdsForSave();
		List<BeutyUser> userList = new ArrayList<BeutyUser>();
		if (userIds.indexOf(",") == -1) {
			// 전달 받은 사용자 아이디가 하나인 경우
			BeutyUser user = new BeutyUser();
			user.setUserId(Integer.parseInt(userIds));
			userList.add(user);
		} else {
			// 전달 받은 사용자 아이디가 하나가 아니라 여러개가 넘어온 경우
			String[] usrIdArr = userIds.split(",");
			for (int i = 0; i < usrIdArr.length; i++) {
				BeutyUser user = new BeutyUser();
				user.setUserId(Integer.parseInt(usrIdArr[i]));
				userList.add(user);
			}
		}
		
		List<AthrMng> athrMngs = new ArrayList<AthrMng>();
		AthrMng role = athrMngRepository.findByAthrCdIgnoreCase(roleVO.getAthrCd());
		athrMngs.add(role);
		//for(BeutyUser user : roleVO.getBeutyUsers()) {
		for(BeutyUser user : userList) {
			BeutyUser userTmp = beutyUserRepository.findById(user.getUserId()).get();
			userTmp.setAthrMngs(athrMngs);
			beutyUserRepository.save(userTmp);
		}
		
	}

	@Override
	public void selectUserRoleList(BeutyUser userVO, ModelMap model) throws Exception {
		Pageable pageable = PageRequest.of(userVO.getPageIndex()-1, userVO.getPageUnit());
		Page<BeutyUser> selectList = null;
		if(userVO.getSearchKeyword()!=null && userVO.getSearchCondition()!=null) {
			if(userVO.getDelYn()!=null&&!userVO.getDelYn().equals("")) {
				if(userVO.getSearchCondition().equals("userNm")) {
				    selectList = beutyUserRepository.findByUserNmIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), userVO.getDelYn(), pageable);
				}else {
				    selectList = beutyUserRepository.findByEmailAddrIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), userVO.getDelYn(),pageable);
				}
			}else {
				if(userVO.getSearchCondition().equals("userNm")) {
				    selectList = beutyUserRepository.findByUserNmIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), "N", pageable);
				}else {
				    selectList = beutyUserRepository.findByUserNmIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), "N", pageable);
				}
			}
		}
		//총 카운트 
		long cnt = selectList.getTotalElements();
		
		userVO.setPageIndex(selectList.getPageable().getPageNumber()+1);
		userVO.setPageSize(selectList.getPageable().getPageSize());
		model.addAttribute("userRoleList", selectList.getContent());
		model.addAttribute("userRoleListCnt", cnt);
	}

	@Override
	public Map<String, Object> selectUserRoleForPopup(BeutyUser userVO) throws Exception {
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		BeutyUser user = beutyUserRepository.findById(userVO.getUserId()).get();
		AthrMng tempUserRole = user.getAthrMngs().get(0);
		if(tempUserRole==null || tempUserRole.getAthrId()==0) {
			tempUserRole = null;
		}
		
		List<AthrMng> roleList = athrMngRepository.findAllByAthrIdNot(tempUserRole.getAthrId());
		
		rsltMap.put("tempRole", tempUserRole);
		rsltMap.put("roleList", roleList);
		
		return rsltMap;
	}

	@Override
	public int updateUserRoleMapping(BeutyUser userVO) throws Exception {
		return mergeIntoRoleUserMapping(userVO);
	}

}
