package com.beauate.ceo.login.web;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.role.service.RoleManageService;
import com.beauate.ceo.common.GlobalContants;
import com.beauate.ceo.login.service.LoginVO;
import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;
import com.beauate.core.repository.BeutyUserRepository;

@Controller
public class LoginController {
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	BeutyUserRepository beutyUserRepository;
	
	@Resource(name = "roleService")
	private RoleManageService roleService;

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
	public String afterLogin(HttpServletRequest request, SessionStatus status, @ModelAttribute BeutyUser beutyUser, ModelMap model) {
        
        //========================== @.사용자 정보 세팅
		Optional<BeutyUser> userOp = beutyUserRepository.findByEmailAddrAndUserPw(beutyUser.getEmailAddr(), beutyUser.getUserPw());
        if(!userOp.isPresent()){
        	model.addAttribute("message", "로그인정보가 잘못되었습니다. 확인해주십시오.");
            model.addAttribute("redirectUrl", "/login/a/n/login.do");

            return "/common/temp_action_message";
        }
        BeutyUser user = userOp.get();
		LoginVO resultVO = new LoginVO();
		resultVO.setUserId(user.getUserId());
		resultVO.setAddr(user.getAddr());
		resultVO.setDelYn(user.getDelYn());
		resultVO.setEmailAddr(user.getEmailAddr());
		resultVO.setFaxNo(user.getFaxNo());
		resultVO.setJoinDt(user.getJoinDt());
		resultVO.setMblPno(user.getMblPno());
		resultVO.setModDt(user.getModDt());
		resultVO.setModId(user.getModId());
		resultVO.setPno(user.getPno());
		resultVO.setUserEngNm(user.getUserEngNm());
		resultVO.setUserNm(user.getUserNm());
		resultVO.setUserPw(user.getUserPw());
		resultVO.setZipNo(user.getZipNo());
		resultVO.setAthrMngs(user.getAthrMngs());
		resultVO.setCnntLogs(user.getCnntLogs());
		resultVO.setAddrDetail(user.getAddrDetail());
        //========================== @.권한 세팅
		resultVO.setRoleList(resultVO.getAthrMngs());
        //========================== @.상단 포탈관리 버튼 권한 구분값(포탈관리 메뉴에 권한이 한개라도 있으면 Y)
        //MenuMngs.menuSe = 2, beutyUsers.userId = ? 인 값을 가져오면 된다.
		int portalManageMenuCnt = roleService.selectPortalManageRoleCnt(resultVO);
        if(portalManageMenuCnt > 0){
            resultVO.setPortalManageGunbun("Y");
        }
        log.debug("loginService.selectUserRoleList.size:"+resultVO.getRoleList().size());
        
        if(portalManageMenuCnt > 0){
            resultVO.setPortalManageGunbun("Y");
        }
        log.debug("loginService.selectUserRoleList.size:"+resultVO.getRoleList().size());
        
        request.getSession().setAttribute(GlobalContants.LOGIN_SESSION_KEY, resultVO);
        
        status.setComplete();
        
        return "redirect:/common/a/n/portalAdminBridge.do";
	}
}
