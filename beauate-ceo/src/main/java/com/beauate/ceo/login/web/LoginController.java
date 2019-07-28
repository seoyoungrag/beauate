package com.beauate.ceo.login.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.core.entity.BeutyUser;
import com.beauate.core.repository.BeutyUserRepository;

@Controller
public class LoginController {
	
	@Autowired
	BeutyUserRepository beutyUserRepository;

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
	public String login(@ModelAttribute BeutyUser beutyUser) throws Exception {
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
	public String afterLogin(SessionStatus status, @ModelAttribute BeutyUser beutyUser) {
		Optional<BeutyUser> result = beutyUserRepository.findByEmailAddrAndUserPw(beutyUser.getEmailAddr(), beutyUser.getUserPw());
		result.isPresent();
		return null;
	}
}
