package com.beauate.ceo.admin.role.service;

import org.springframework.ui.ModelMap;

import com.beauate.core.entity.AthrMng;

public interface RoleManageService {

// 권한 그룹 관리 Start
	/**
	 * <pre>
	 * 1. 개요 : 권한 관리의 첫 화면에 뿌려지는 권한 그룹 목록
	 * 2. 처리내용 : 권한 관리의 첫 화면에 뿌려지는 권한 그룹 목록
	 * </pre>
	 * @Method Name : selectRoleGroupList
	 * @date : 2016. 6. 24.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	-----------------------------------------------------------------------
	 *	2016. 6. 24.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public void selectRoleGroupList(AthrMng roleVO, ModelMap model) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹의 상세 정보
	 * 2. 처리내용 : 사용자가 요청하는 권한 그룹의 상세 정보를 가져온다.
	 * </pre>
	 * @Method Name : selectRoleGroupDetail
	 * @date : 2016. 6. 27.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	-----------------------------------------------------------------------
	 *	2016. 6. 27.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public void selectRoleGroupDetail(AthrMng roleVO, ModelMap model) throws Exception;
	
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹 정보를 삭제
	 * 2. 처리내용 : 사용자가 요청하는 권한 그룹 정보를 삭제 한다.
	 * </pre>
	 * @Method Name : deleteRoleGroup
	 * @date : 2016. 6. 27.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	-----------------------------------------------------------------------
	 *	2016. 6. 27.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */ 	
	public void deleteRoleGroup(AthrMng roleVO) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹 정보 수정
	 * 2. 처리내용 : 관리자가 권한 정보를 수정 한 후 저장 한다.
	 * </pre>
	 * @Method Name : updateRoleGroup
	 * @date : 2016. 6. 28.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 28.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */ 	
	public void updateRoleGroup(AthrMng roleVO) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : insertRoleGroup
	 * @date : 2016. 6. 28.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자					변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 28.		김명준					최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	public int insertRoleGroup(AthrMng roleVO) throws Exception;
// 권한 그룹 관리 End
	
	
}
