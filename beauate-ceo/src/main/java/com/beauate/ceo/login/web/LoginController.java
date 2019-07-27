package com.beauate.ceo.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.HttpServletBean;

import com.beauate.ceo.login.service.LoginVO;

@Controller
public class LoginController {

	/**
	 * <pre>
	 * 1. 개요 : 로그인 화면
	 * 2. 처리내용 : 로그인 화면
	 * </pre>
	 * @Method Name : login
	 * @date : 2019. 06. 06.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 06. 06.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param 
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/login/a/n/login.do")
	public String login() throws Exception {
		return "/login/login";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 로그인 화면
	 * 2. 처리내용 : 로그인 화면
	 * </pre>
	 * @Method Name : login
	 * @date : 2019. 06. 06.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 06. 06.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param 
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/a/n/afterLogin.do")
	public String afterLogin(HttpServletRequest request, HttpServletResponse response, SessionStatus status, String user_id, @ModelAttribute("loginVO") LoginVO loginVO, ModelMap model) {
		return null;
	}
}
