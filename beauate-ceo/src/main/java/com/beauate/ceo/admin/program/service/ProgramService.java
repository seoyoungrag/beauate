package com.beauate.ceo.admin.program.service;

import org.springframework.ui.ModelMap;

public interface ProgramService {
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 리스트
	 * 2. 처리내용 : 프로그램관리 리스트
	 * </pre>
	 * @Method Name : selectProgramList
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.  		신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return List<ProgramVO>
	 * @throws Exception
	 */ 	
	public void selectProgramList(ProgramVO programVO, ModelMap model) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 등록시 프로그램 변수 중복 검사
	 * 2. 처리내용 : 프로그램 등록시 프로그램 변수 중복 검사
	 * </pre>
	 * @Method Name : selectProgramParamChk
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return int
	 * @throws Exception
	 */ 	
	public void selectProgramParamChk(ProgramVO programVO, ModelMap model) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 등록 한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 등록 한다 
	 * </pre>
	 * @Method Name : insertProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.  신호석			 	          최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return int
	 * @throws Exception
	 */ 	
	public void insertProgramProc(ProgramVO programVO) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 선택된 프로그램 상세정보를 가져온다.
	 * 2. 처리내용 : 선택된 프로그램 상세정보를 가져온다.
	 * </pre>
	 * @Method Name : selectProgramDetail
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return ProgramVO
	 * @throws Exception
	 */ 	
	public void selectProgramDetail(ProgramVO programVO, ModelMap model) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 수정한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 수정한다 
	 * </pre>
	 * @Method Name : updateProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일		         	 작성자				          변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.			신호석				           최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return int
	 * @throws Exception
	 */ 	
	public void updateProgramProc(ProgramVO programVO) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 삭제한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 삭제한다 
	 * </pre>
	 * @Method Name : deleteProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일		         	 작성자				          변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.			신호석				           최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */
	public void deleteProgramProc(ProgramVO programVO) throws Exception;
}
