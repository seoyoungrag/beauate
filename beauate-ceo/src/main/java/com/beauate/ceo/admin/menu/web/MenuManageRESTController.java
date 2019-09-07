package com.beauate.ceo.admin.menu.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.menu.service.MenuManageService;
import com.beauate.ceo.admin.program.service.ProgramManageService;
import com.beauate.ceo.login.service.LoginVO;
import com.beauate.core.entity.MenuMng;

@RestController
public class MenuManageRESTController {
	protected Log log = LogFactory.getLog(this.getClass());

    @Resource(name = "menuService")
    private MenuManageService menuService;

    @Resource(name = "programService")
    private ProgramManageService programService;


    /**
     * <pre>
     * 1. 개요 : 메뉴 와 권한 맵핑 저장
     * 2. 처리내용 : 메뉴 와 권한 맵핑 저장
     * </pre>
     * @Method Name : saveRoleMapp
     * @date : 2016. 6. 13.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	-----------------------------------------------------------------------
     *	2016. 6. 13.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param menuVO
     * @param status
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */ 	
    @RequestMapping(value = "/menu/z/n/saveRoleMapp.do")
    public Map saveRoleMapp(@ModelAttribute("menuVO") MenuMng menuVO,
            SessionStatus status, LoginVO sessionVO, ModelMap model)
            throws Exception {

        // 아이디 세팅
        menuVO.setRegId("saveTestId");
        
        menuService.saveRoleMapp(menuVO);
        
        // 중복 submit 방지
        status.setComplete();

    	Map<String, Object> rtnMap = new HashMap<String,Object>();
    	rtnMap.put("chkResult", "Y");
        return rtnMap;
    }
    
}
