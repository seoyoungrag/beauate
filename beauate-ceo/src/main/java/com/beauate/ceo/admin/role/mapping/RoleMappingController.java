package com.beauate.ceo.admin.role.mapping;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;

@Controller
public class RoleMappingController {

	@Resource(name = "roleMappingService")
	private RoleMappingService roleMappingService;
	
	/**************************************************** 권한별 사용자 관리(S) */

	/**
	 * <pre>
	 * 1. 개요 : 권한별 사용자 관리 목록
	 * 2. 처리내용 : 권한 그룹 정보만 불러 온다. (권한에 따른 사용자 목록은 따로 호출. ajaxUserInfoList)
	 * </pre>
	 * @Method Name : selectRoleUserList
	 * @date : 2016. 6. 30.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 30.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/z/m/selectRoleUserList.do")
	public String selectRoleUserList(ModelMap model) throws Exception {

		List<AthrMng> roleInfoList = roleMappingService.selectRoleNameOfRoleUser();
		model.addAttribute("roleInfoList", roleInfoList);

		return "/admin/role/roleUserMng/selectRoleUserList";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹별 사용자 목록
	 * 2. 처리내용 : 권한 그룹에 따른 사용자 목록을 조회 한다. ajax
	 * </pre>
	 * @Method Name : ajaxUserInfoList
	 * @date : 2016. 6. 30.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 30.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/r/n/ajaxUserInfoList.do")
	public String ajaxUserInfoList(AthrMng roleVO, ModelMap model) throws Exception {

		List<BeutyUser> roleUserList = roleMappingService.selectRoleUserList(roleVO);
		model.addAttribute("roleUserList", roleUserList);
		model.addAttribute("roleGroup", roleVO.getAthrCd());

		return "/admin/role/roleUserMng/ajaxUserInfoList";
	}

	/**
	 * <pre>
	 * 1. 개요 : 권한별 사용자 관리 화면 > 권한 추가 화면 이동
	 * 2. 처리내용 : 관리자가 추가 버튼 클릭 시 권한 추가 화면으로 이동 한다.
	 * </pre>
	 * @Method Name : insertRoleUserPopup
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
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/w/n/insertRoleUserPopup.do")
	public String insertRoleUserPopup(AthrMng roleVO, ModelMap model) throws Exception {

		List<BeutyUser> roleUserListForUpdate = roleMappingService.selectUserListForUpdateRole(roleVO);

		model.addAttribute("roleUserListForUpdate", roleUserListForUpdate);
		model.addAttribute("roleCode", roleVO.getAthrCd());

		return "/admin/role/roleUserMng/popUpLayer/insertRoleUser";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 추가 popUp 화면의 사용자 검색 결과 목록
	 * 2. 처리내용 : 관리자가 권한 추가 화면에서 찾고자 하는 사용자를 검색 한 후 결과를 ajax로 return
	 * </pre>
	 * @Method Name : selectSearchRoleUserList
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
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/w/n/selectSearchRoleUserList.do")
	public String selectSearchRoleUserList(AthrMng roleVO, ModelMap model) throws Exception {
		
		List<BeutyUser> roleUserListForUpdate = roleMappingService.selectUserListForUpdateRole(roleVO);

		model.addAttribute("roleUserListForUpdate", roleUserListForUpdate);
		
		return "/admin/role/roleUserMng/popUpLayer/searchResult";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자의 권한 변경 처리
	 * 2. 처리내용 : 사용자의 권한을 변경 처리 한다.
	 * </pre>
	 * @Method Name : saveRoleUserProc
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
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/z/n/saveRoleUserProc.do")
	public String saveRoleUserProc(AthrMng roleVO, SessionStatus status) throws Exception {

		roleMappingService.updateRoleUserMapping(roleVO);
		status.setComplete();

		return "redirect:/roleuser/z/m/selectRoleUserList.do";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한별 사용자 관리 > 해당 사용자 권한 삭제(인증 되지 않은 사용자로 전환)
	 * 2. 처리내용 : 권한별 사용자 목록에서 해당하는 사용자의 권한을 삭제 한다.
	 * </pre>
	 * @Method Name : deleteRoleUserPrco
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
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/roleuser/z/n/deleteRoleUserProc.do")
	public String deleteRoleUserPrco(AthrMng roleVO, SessionStatus status) throws Exception {
		
		roleVO.setAthrCd("unauthenticated");

		roleMappingService.updateRoleUserMapping(roleVO);
		status.setComplete();

		return "redirect:/roleuser/z/m/selectRoleUserList.do";
	}
	/**************************************************** 권한별 사용자 관리(E) */
	
	
	/**************************************************** 사용자별 권한 관리(S) */

	/**
	 * <pre>
	 * 1. 개요 : 사용자 별 권한 관리 목록
	 * 2. 처리내용 : 사용자 별 권한을 관리 할 수 있다.
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
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userrole/z/m/selectUserRoleList.do")
	public String selectUserRoleList(@ModelAttribute("userVO") BeutyUser userVO, ModelMap model) throws Exception {
		roleMappingService.selectUserRoleList(userVO, model);
		return "/admin/role/userRoleMng/selectUserRoleList";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 별 권한 확인 팝업 목록
	 * 2. 처리내용 : 사용자 별 권한을 확인하는 팝업 화면의 목록을 불러온다.
	 * </pre>
	 * @Method Name : selectUserRolePopList
	 * @date : 2016. 7. 25.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 7. 6.			김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userrole/z/n/selectUserRolePopList.do")
	public String selectUserRolePopList(BeutyUser userVO, ModelMap model) throws Exception {
		
		Map<String, Object> rslt = roleMappingService.selectUserRoleForPopup(userVO);
		model.addAttribute("rslt", rslt);
		
		return "/admin/role/userRoleMng/popUpLayer/insertUserRole";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자별 권한을 수정 한 후 저장 한다.
	 * 2. 처리내용 : 사용자별 권한을 수정한 후 해당 권한으로 저장한다.
	 * </pre>
	 * @Method Name : saveUserRoleProc
	 * @date : 2016. 7. 25.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자				변경내용
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 7. 6.			김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/userrole/z/n/saveUserRoleProc.do")
	public String saveUserRoleProc(BeutyUser userVO) throws Exception {
		
		roleMappingService.updateUserRoleMapping(userVO);
		
		return "redirect:/userrole/z/m/selectUserRoleList.do";
	}
	/**************************************************** 사용자별 권한 관리(E) */
}
