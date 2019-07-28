package com.beauate.ceo.admin.user.service;

import org.springframework.ui.ModelMap;

public interface UserManageService {
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 목록 리스트
	 * 2. 처리내용 : 사용자 목록 조회
	 * </pre>
	 * @Method Name : selectUserList
	 * @date : 2019. 07. 07.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 11. 02.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */ 
	public void selectUserList(UserVO userVO, ModelMap model) throws Exception;
	
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
	public UserVO selectUserDetail(UserVO userVO) throws Exception;
	
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
	public Integer selectUserMailChk(UserVO userVO) throws Exception;
	
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
	public void insertUserProc(UserVO userVO) throws Exception;
	
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
	public void updateUserProc(UserVO userVO) throws Exception;
	
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
	public void deleteUserProc(UserVO userVO) throws Exception;
}
