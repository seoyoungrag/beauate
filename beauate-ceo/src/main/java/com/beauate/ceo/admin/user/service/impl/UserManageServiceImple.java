package com.beauate.ceo.admin.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.user.service.UserDao;
import com.beauate.ceo.admin.user.service.UserManageService;
import com.beauate.ceo.admin.user.service.UserVO;
import com.beauate.ceo.common.GlobalContants;
import com.beauate.ceo.common.service.PaginationInfo;
import com.beauate.core.entity.BeutyUser;
import com.beauate.core.entity.PrgrMng;
import com.beauate.core.repository.BeutyUserRepository;

@Service("userManageService")
public class UserManageServiceImple implements UserManageService {

	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BeutyUserRepository beutyUserRepository; 
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 리스트
	 * 2. 처리내용 : 사용자 리스트를 불러온다.
	 * </pre>
	 * @Method Name : selectUserList
	 * @date : 2019. 07. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public void selectUserList(UserVO userVO, ModelMap model) throws Exception {
		Pageable pageable = PageRequest.of(1, 10);
		Page<PrgrMng> selectList = null;
		if(userVO.getSearchKeyword()!=null && userVO.getSearchCondition()!=null) {
			if(userVO.getDel_yn()!=null&&!userVO.getDel_yn().equals("")) {
				if(userVO.getSearchCondition().equals("user_nm")) {
				    selectList = beutyUserRepository.findByUserNmIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), userVO.getDel_yn(), pageable);
				}else {
				    selectList = beutyUserRepository.findByEmailAddrIgnoreCaseContainingAndDelYn(userVO.getSearchKeyword(), userVO.getDel_yn(),pageable);
				}
			}else {
				if(userVO.getSearchCondition().equals("user_nm")) {
				    selectList = beutyUserRepository.findByUserNmIgnoreCaseContaining(userVO.getSearchKeyword(), pageable);
				}else {
				    selectList = beutyUserRepository.findByEmailAddrIgnoreCaseContaining(userVO.getSearchKeyword(), pageable);
				}
			}
		}
		//총 카운트 
		long cnt = selectList.getTotalElements();
						
		model.addAttribute("userList", selectList);
		model.addAttribute("userListCnt", cnt);
	}

	/**
	 * <pre>
	 * 1. 개요 : 사용자 상세정보
	 * 2. 처리내용 :  사용자 상세정보
	 * </pre>
	 * @Method Name : selectUserList
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08  신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */ 
	public UserVO selectUserDetail(UserVO userVO) throws Exception {
		//return beutyUserRepository.findById(userVO.getUser_id());
		return null;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자이메일 중복체크
	 * 2. 처리내용 : 사용자이메일 중복체크
	 * </pre>
	 * @Method Name : selectUserList
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08  신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */ 
	public Integer selectUserMailChk(UserVO userVO) throws Exception {
		Pageable pageable = PageRequest.of(1, 10);
		return (int) beutyUserRepository.findByEmailAddrIgnoreCaseContaining(userVO.getEmail_addr().trim(), pageable).getTotalElements();
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 등록
	 * 2. 처리내용 : 사용자 등록
	 * </pre>
	 * @Method Name : insertUserProc
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08  신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */ 
	public void insertUserProc(UserVO userVO) throws Exception {
		//userDao.insertUserProc(userVO);
		//권한등록처리 필요
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 수정
	 * 2. 처리내용 : 사용자 수정
	 * </pre>
	 * @Method Name : updateUserProc
	 * @date : 2019. 07. 20.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08  신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */ 
	public void updateUserProc(UserVO userVO) throws Exception {
		//userDao.updateUserProc(userVO);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 삭제
	 * 2. 처리내용 : 사용자 삭제
	 * </pre>
	 * @Method Name : deleteUserProc
	 * @date : 2019. 07. 20.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08  신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */ 
	public void deleteUserProc(UserVO userVO) throws Exception {
		//userDao.deleteUserProc(userVO);
	}
}
