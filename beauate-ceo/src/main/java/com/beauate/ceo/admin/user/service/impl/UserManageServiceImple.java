package com.beauate.ceo.admin.user.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.user.service.UserManageService;
import com.beauate.ceo.admin.user.service.UserVO;
import com.beauate.core.entity.BeutyUser;
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
	public void selectUserList(BeutyUser userVO, ModelMap model) throws Exception {
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
		model.addAttribute("userList", selectList.getContent());
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
	public BeutyUser selectUserDetail(BeutyUser userVO) throws Exception {
		return beutyUserRepository.findById(userVO.getUserId()).get();
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
	public void updateUserProc(BeutyUser userVO) throws Exception {
		BeutyUser user = beutyUserRepository.findById(userVO.getUserId()).get();
		if(userVO.getUserNm()!=null) {
			user.setUserNm(userVO.getUserNm());
		}
		if(userVO.getUserPw()!=null) {
			user.setUserPw(userVO.getUserPw());
		}
		if(userVO.getUserEngNm()!=null) {
			user.setUserEngNm(userVO.getUserEngNm());
		}
		if(userVO.getZipNo()!=null) {
			user.setZipNo(userVO.getZipNo());
		}
		if(userVO.getAddr()!=null) {
			user.setAddr(userVO.getAddr());
		}
		if(userVO.getAddrDetail()!=null) {
			user.setAddrDetail(userVO.getAddrDetail());
		}
		if(userVO.getMblPno()!=null) {
			user.setMblPno(userVO.getMblPno());
		}
		if(userVO.getPno()!=null) {
			user.setPno(userVO.getPno());
		}
		if(userVO.getFaxNo()!=null) {
			user.setFaxNo(userVO.getFaxNo());
		}
		user.setModDt(new Date());
		beutyUserRepository.save(user);
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
	public void deleteUserProc(BeutyUser userVO) throws Exception {
		BeutyUser user = beutyUserRepository.findById(userVO.getUserId()).get();
		user.setDelYn("Y");
		beutyUserRepository.save(user);
		//beutyUserRepository.delete(userVO);
	}
}
