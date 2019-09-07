package com.beauate.ceo.admin.menu.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.beauate.core.entity.MenuMng;
import com.beauate.core.entity.MenuStat;

public interface MenuManageService {
	
    /**
     * <pre>
     * 1. 개요 : 메뉴의 트리 리스트
     * 2. 처리내용 : 메뉴의 트리 리스트
     * </pre>
     * @Method Name : selectMenuList
     * @date : 2016. 5. 17.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 5. 17.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param menuVO
     * @param model
     * @return
     * @throws Exception
     */ 	
    public void selectMenuList(MenuMng menuVO, ModelMap model) throws Exception;
    
}
