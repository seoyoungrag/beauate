package com.beauate.ceo.admin.menu.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.menu.service.MenuManageService;
import com.beauate.ceo.admin.program.service.ProgramManageService;
import com.beauate.ceo.admin.program.service.ProgramVO;
import com.beauate.ceo.login.service.LoginVO;
import com.beauate.core.entity.MenuMng;
import com.beauate.core.entity.MenuStat;

@Controller
public class MenuManageController {
	protected Log log = LogFactory.getLog(this.getClass());

    @Resource(name = "menuService")
    private MenuManageService menuService;

    @Resource(name = "programService")
    private ProgramManageService programService;

    /**
     * <pre>
     * 1. 개요 : 메뉴 관리의 메뉴체계도 트리 리스트 화면
     * 2. 처리내용 : 메뉴 관리의 메뉴체계도 트리 리스트 화면
     * </pre>
     * @Method Name : selectMenuList
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
     * @param model
     * @return
     * @throws Exception
     */ 	
    @RequestMapping(value = "/menu/r/m/selectMenuList.do")
    public String selectMenuList(@ModelAttribute("menuVO") MenuMng menuVO,
            ModelMap model) throws Exception {
        menuService.selectMenuList(menuVO, model);
        return "/admin/menu/menuList";
    }

}
