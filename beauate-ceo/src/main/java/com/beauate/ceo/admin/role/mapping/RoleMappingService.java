package com.beauate.ceo.admin.role.mapping;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;

interface RoleMappingService {

	// 권한별 사용자 관리 Start
		/**
		 * <pre>
		 * 1. 개요 : 권한별 사용자 관리의 권한 정보 목록
		 * 2. 처리내용 : 권한별 사용자 관리의 권한 정보 목록을 가져온다.
		 * </pre>
		 * @Method Name : selectRoleNameOfRoleUser
		 * @date : 2016. 6. 29.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 6. 29.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @return
		 * @throws Exception
		 */
		public List<AthrMng> selectRoleNameOfRoleUser() throws Exception;
		
		/**
		 * <pre>
		 * 1. 개요 : 권한별 사용자 목록
		 * 2. 처리내용 : 권한별 사용자 목록을 가져온다.
		 * </pre>
		 * @Method Name : selectRoleUserList
		 * @date : 2016. 6. 29.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 6. 29.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @return
		 * @throws Exception
		 */
		public List<BeutyUser> selectRoleUserList(AthrMng roleVO) throws Exception;
		
		
		/**
		 * <pre>
		 * 1. 개요 : 권한별 사용자 관리에서 해당 권한이 없는 사용자 목록
		 * 2. 처리내용 : 현재의 선택된 권한에서 해당 권한이 없는 사용자의 목록을 뿌려준다.
		 * </pre>
		 * @Method Name : selectUserListForUpdateRole
		 * @date : 2016. 6. 30.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자				변경내용
		 *	-----------------------------------------------------------------------
		 *	2016. 6. 30.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @return
		 * @throws Exception
		 */
		public List<BeutyUser> selectUserListForUpdateRole(AthrMng roleVO) throws Exception;
		
		/**
		 * <pre>
		 * 1. 개요 : 권한별 사용자 등록 혹은 수정
		 * 2. 처리내용 : 권한별 사용자를 등록하는데, 권한이 존재 하는 사용자면 update, 존재하지 않으면 insert
		 * </pre>
		 * @Method Name : updateRoleUserMapping
		 * @date : 2016. 7. 1.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자				변경내용
		 *	------------------------------ ---------------------------------------
		 *	2016. 7. 1.			김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @return
		 * @throws Exception
		 */ 	
		public int mergeIntoRoleUserMapping(BeutyUser userVO) throws Exception;
		
		/**
		 * <pre>
		 * 1. 개요 : 권한별 사용자의 권한 변경
		 * 2. 처리내용 : 관리자가 요청한 사용자의 권한을 변경 처리한다.
		 * </pre>
		 * @Method Name : updateRoleUserMapping
		 * @date : 2016. 7. 5.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일			작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 7. 5.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @throws Exception
		 */
		public void updateRoleUserMapping(AthrMng roleVO) throws Exception;
	// 권한별 사용자 관리 End

	// 사용자별 권한 관리 Start
		/**
		 * <pre>
		 * 1. 개요 : 사용자 별 권한 관리 목록
		 * 2. 처리내용 : 사용자 별 권한 관리 목록
		 * </pre>
		 * @Method Name : selectUserRoleList
		 * @date : 2016. 7. 6.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일			작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 7. 6.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @return
		 * @throws Exception
		 */
		public void selectUserRoleList(BeutyUser userVO, ModelMap model) throws Exception;
		
		/**
		 * <pre>
		 * 1. 개요 : 사용자의 권한 조회
		 * 2. 처리내용 : 사용자의 현재 권한 조회
		 * </pre>
		 * @Method Name : selectUserRoleForPopup
		 * @date : 2016. 7. 6.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일			작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 7. 6.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @return
		 * @throws Exception
		 */
		public Map<String, Object> selectUserRoleForPopup(BeutyUser userVO) throws Exception;
		
		/**
		 * <pre>
		 * 1. 개요 : 사용자 별 권한 변경 처리
		 * 2. 처리내용 : 사용자 별 권한 변경 처리
		 * </pre>
		 * @Method Name : updateUserRoleMapping
		 * @date : 2016. 7. 7.
		 * @author : 김명준
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일			작성자				변경내용
		 *	------------------------------- ---------------------------------------
		 *	2016. 7. 7.		김명준				최초 작성
		 *	-----------------------------------------------------------------------
		 * 
		 * @param roleVO
		 * @return
		 * @throws Exception
		 */
		public int updateUserRoleMapping(BeutyUser userVO) throws Exception;
}
