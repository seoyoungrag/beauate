package com.beauate.ceo.admin.user.web;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.user.service.UserManageService;
import com.beauate.ceo.admin.user.service.UserVO;

@Controller
public class UserManageController {
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name = "userManageService")
	private UserManageService userManageService;
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자관리 리스트
	 * 2. 처리내용 : 사용자관리 리스트
	 * </pre>
	 * @Method Name : selectUserList
	 * @date : 2019. 07. 07.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 07.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/m/selectUserList.do")
	public String selectUserList(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		userManageService.selectUserList(userVO, model);
		return "/admin/user/userList";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 상세정보
	 * 2. 처리내용 : 사용자 상세정보
	 * </pre>
	 * @Method Name : selectUserDetail
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/m/selectUserDetail.do")
	public String selectUserDetail(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		userVO = userManageService.selectUserDetail(userVO);
		model.addAttribute("userVO", userVO);
		return "/admin/user/userDetail";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 정보 등록화면
	 * 2. 처리내용 : 사용자 정보 등록화면
	 * </pre>
	 * @Method Name : insertUser
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/m/insertUser.do")
	public String insertUser(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		return "/admin/user/userInsert";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자이메일 중복체크
	 * 2. 처리내용 : 사용자이메일 중복체크
	 * </pre>
	 * @Method Name : selectUserMailChk
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/n/selectUserMailChk.do")
	public String selectUserMailChk(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		int cnt = userManageService.selectUserMailChk(userVO);
		if (cnt > 0) {
			model.addAttribute("chkResult", "N");
		} else {
			model.addAttribute("chkResult", "Y");
		}
		return "jsonView";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 정보 등록
	 * 2. 처리내용 : 사용자 정보 등록
	 * </pre>
	 * @Method Name : selectUserMailChk
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/n/insertUserProc.do")
    public String insertUserProc(@ModelAttribute("userVO") UserVO userVO, SessionStatus status, ModelMap model) throws Exception {
		String message;
		String redirectUrl;
		try {
			userManageService.insertUserProc(userVO);
			redirectUrl = "/usermgr/z/m/selectUserList.do";
			message = "등록 되었습니다.";
			// 중복 submit 방지
			status.setComplete();
		} catch (Exception e) {
			log.debug(e.getMessage());
			redirectUrl = "/usermgr/z/m/insertUser.do";
			message = "현재 서비스가 원활하지 않습니다.\n잠시후 다시 이용해 주십시요.";
		}
		model.addAttribute("message", message);
		model.addAttribute("redirectUrl", redirectUrl);

		return "/common/temp_action_message";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 정보 수정화면 이동
	 * 2. 처리내용 : 사용자 정보 수정화면 이동
	 * </pre>
	 * @Method Name : updateUser
	 * @date : 2019. 07. 08.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 08.		신호석				최초 작성
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/m/updateUser.do")
	public String updateUser(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		userVO = userManageService.selectUserDetail(userVO);
		model.addAttribute("userVO", userVO);
		return "/admin/user/userUpdate";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 수정
	 * 2. 처리내용 : 사용자 관리자가 사용자 정보를 수정한다.
	 * </pre>
	 * @Method Name : userUpdateProc
	 * @date : 2019. 07. 20.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 20.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/n/updateUserProc.do")
	public String userUpdateProc(@ModelAttribute("userVO") UserVO userVO, SessionStatus status, ModelMap model) throws Exception {
		userManageService.updateUserProc(userVO);
		// 중복 submit 방지
		status.setComplete();
		return "redirect:/usermgr/z/m/selectUserDetail.do?user_id="+userVO.getUser_id();
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 사용자 삭제
	 * 2. 처리내용 : 사용자 관리자가 사용자 정보를 삭제한다.
	 * </pre>
	 * @Method Name : userUpdateProc
	 * @date : 2019. 07. 20.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 20.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermgr/z/n/deleteUserProc.do")
	public String deleteUserProc(@ModelAttribute("userVO") UserVO userVO, SessionStatus status, ModelMap model) throws Exception {
		userManageService.deleteUserProc(userVO);
		status.setComplete();
		return "redirect:/usermgr/z/m/selectUserList.do";
	}
}
