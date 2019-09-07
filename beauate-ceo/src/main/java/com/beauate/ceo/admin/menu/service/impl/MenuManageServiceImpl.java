package com.beauate.ceo.admin.menu.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.menu.service.MenuManageService;
import com.beauate.core.entity.MenuMng;
import com.beauate.core.repository.MenuMngRepository;

/**
 * @author 양태욱
 *
 */
@Service("menuService")
public class MenuManageServiceImpl implements MenuManageService {

	protected Log log = LogFactory.getLog(this.getClass());

	@Autowired
    private MenuMngRepository menuMngRepository;
    
    /**
     * <pre>
     * 1. 개요 : 메뉴의 트리 리스트 
     * 2. 처리내용 : 메뉴의 트리 리스트 
     * </pre>
     * @Method Name : selectMenuList
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectMenuList(kr.co.enkiadmin.admin.menu.service.MenuMng, org.springframework.ui.ModelMap)
     * @param menuVO
     * @param model
     * @return
     * @throws Exception
     */ 	
    @Override
    public void selectMenuList(MenuMng menuVO, ModelMap model) throws Exception{
        //메뉴 리스트
        List<MenuMng> selectList = menuMngRepository.selectMenuList();
        
        //왼쪽 메뉴 클릭 시 초기 세팅값 ( 트리중에서 root를 제외한 0 )제일 상단 값 세팅)
        /*
        if("I".equals(StringUtil.nvl(menuVO.getMenuUrlGubun()).trim()) || "".equals(StringUtil.nvl(menuVO.getMenuId()).trim())){
    		MenuMng tempVO = null;
    		
    		for (int i = 0; i < selectList.size(); i++) {
    			
    			tempVO = new MenuMng();
    			tempVO = selectList.get(i);
    			
    			if(tempVO.getUprMenuId() != null){
    				menuVO.setMenuId(tempVO.getMenuId());
    				menuVO.setLevel(tempVO.getLevel());
    				menuVO.setMenuLup(tempVO.getMenuLup());
    				menuVO.setUprMenuId(tempVO.getUprMenuId());
    				break;
    			}
    		}
        }
            */
		model.addAttribute("menuList", selectList);
    }
    
}
