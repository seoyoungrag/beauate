package com.beauate.ceo.admin.role.web;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.role.service.RoleManageService;
import com.beauate.ceo.login.service.LoginVO;
import com.beauate.core.entity.AthrMng;

/**
 * * 프로그램 정보
 * 1. Package	:	kr.co.enkiadmin.admin.role.web
 * 2. FileName	:	RoleController.java
 * 3. 작성자		:	김명준
 * 4. 작성일		:	2016. 05. 17
 * 5. 설명		:	권한 관리 (권한 그룹, 권한 별 사용자, 사용자 별 권한, 권한별 사용자 통계)에 관련된
 * 					리스트 , 상세 , 수정 , 삭제 등의 모든 기능의 화면을 보여주는 controller
 * 6. 수정이력
 * @
 * @ 수정일				수정자				수정내용
 * @ -------------		---------			-------------------------------
 * @ 2016. 05. 17		김명준				최초생성
 */
@Controller
public class RoleManageController {

	protected Log log = LogFactory.getLog(this.getClass());

	@Resource(name = "roleService")
	private RoleManageService roleService;


	/**************************************************** 권한그룹 관리(S) */
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹 목록
	 * 2. 처리내용 : 권한 그룹 관리 목록을 가져온다.
	 * </pre>
	 * @Method Name : selectRoleGroupList
	 * @date : 2016. 6. 28.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 28.		김명준				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/role/r/m/selectRoleGroupList.do")
	public String selectRoleGroupList(@ModelAttribute("roleVO") AthrMng roleVO, ModelMap model) throws Exception {
		roleService.selectRoleGroupList(roleVO, model);
		return "/admin/role/roleGroupMng/selectRoleGroupList";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 관리 그룹 정보 등록 화면으로 이동
	 * 2. 처리내용 : 관리자가 새로운 권한 관리를 등록 하기 위해 등록 화면으로 이동.
	 * </pre>
	 * @Method Name : insertRole
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
	@RequestMapping(value = "/role/w/m/insertRoleGroup.do")
	public String insertRole(@ModelAttribute("roleVO") AthrMng roleVO) throws Exception {

		return "/admin/role/roleGroupMng/insertRoleGroup";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 입력 된 권한 관리 정보를 등록 처리
	 * 2. 처리내용 : 관리자가 입력한 새로운 권한 관리 정보를 DB에 입력 처리.
	 * </pre>
	 * @Method Name : insertRoleProc
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
	 * @param sessionVO
	 * @param status
	 * @return
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/role/w/n/insertRoleGroupProc.do")
	public String insertRoleProc(@ModelAttribute("roleVO") AthrMng roleVO
			, LoginVO sessionVO, SessionStatus status) throws Exception {
		
		roleVO.setRegId("test");
		roleService.insertRoleGroup(roleVO);
		
		return "redirect:/role/r/m/selectRoleGroupList.do";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹 상세정보 수정
	 * 2. 처리내용 : 권한 그룹 상세보기 화면에서 수정을 위한 화면으로 이동.
	 * </pre>
	 * @Method Name : updateRoleGroup
	 * @date : 2016. 6. 28.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 28.		김명준				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @param sessionVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/role/w/m/updateRoleGroup.do")
	public String updateRoleGroup(@ModelAttribute("roleVO") AthrMng roleVO
			, ModelMap model, LoginVO sessionVO) throws Exception {
		
		model.addAttribute("sCondition", roleVO.getSearchCondition());
		model.addAttribute("sKeyword", roleVO.getSearchKeyword());

		roleService.selectRoleGroupDetail(roleVO, model);
		
		return "/admin/role/roleGroupMng/updateRoleGroup";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹 정보 수정 처리
	 * 2. 처리내용 : 관리자가 입력한 권한 그룹 관리 사항을 DB에 저장 처리 한다.
	 * </pre>
	 * @Method Name : updateRoleGroupProc
	 * @date : 2016. 6. 28.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	------------------------------- ---------------------------------------
	 *	2016. 6. 28.		김명준						최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/role/w/n/updateRoleGroupProc.do")
	public String updateRoleGroupProc(@ModelAttribute("roleVO") AthrMng roleVO
			, LoginVO sessionVO, SessionStatus status) throws Exception {
		
		roleVO.setUpdtId("testUpdateId");
		roleService.updateRoleGroup(roleVO);
		
		String redirectParam = "searchCondition=" + roleVO.getSearchCondition()
								+ "&searchKeyword=" + roleVO.getSearchKeyword()
								+ "&pageIndex=" + roleVO.getPageIndex()
								+ "&athrId=" + roleVO.getAthrId();
		
		return "redirect:/role/r/m/selectRoleGroupDetail.do?" + redirectParam;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 관리자가 요청하는 권한 그룹의 상세정보를 가져온다.
	 * 2. 처리내용 : 해당 권한의 권한 아이디 값으로 상세 정보 select
	 * </pre>
	 * @Method Name : selectRoleDetail
	 * @date : 2016. 6. 27.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	----------------------------------------- -----------------------------
	 *	2016. 6. 27.		김명준						최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/role/r/m/selectRoleGroupDetail.do")
	public String selectRoleDetail(@ModelAttribute("roleVO") AthrMng roleVO, ModelMap model) throws Exception {
		log.debug(">>> before selectRoleDetail : " + roleVO);
		roleService.selectRoleGroupDetail(roleVO, model);
		log.debug(">>> Afer selectRoleDetail : " + model);
		
		return "/admin/role/roleGroupMng/selectRoleGroupDetail";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 권한 그룹의 상세 정보 화면에서 해당 데이터를 삭제 한다.
	 * 2. 처리내용 : 해당 권한 아이디로 삭제 처리
	 * </pre>
	 * @Method Name : deleteRoleProc
	 * @date : 2016. 6. 27.
	 * @author : 김명준
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	----------------------------------------- -----------------------------
	 *	2016. 6. 27.		김명준						최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param roleVO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/role/w/n/deleteRoleProc.do")
	public String deleteRoleProc(AthrMng roleVO, SessionStatus status) throws Exception {
		
		roleService.deleteRoleGroup(roleVO);
		status.setComplete(); // 중복 방지
		
		return "redirect:/role/r/m/selectRoleGroupList.do?pageIndex=" + roleVO.getPageIndex();
	}
	/**************************************************** 권한그룹 관리(E) */
	
	
}
