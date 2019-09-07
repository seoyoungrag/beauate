package com.beauate.ceo.admin.menu.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.beauate.core.entity.AthrMng;
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
    
    /**
     * <pre>
     * 1. 개요 : 선택된 메뉴의 상세 정보 와 그 메뉴의 권한맵핑 목록 리스트 
     * 2. 처리내용 : 선택된 메뉴의 상세 정보 와 그 메뉴의 권한맵핑 목록 리스트 
     * </pre>
     * @Method Name : selectMenu
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
     * @return
     * @throws Exception
     */ 	
    public MenuMng selectMenu(MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 정렬을 위한 메뉴의 갯수 리스트 
     * 2. 처리내용 : 정렬을 위한 메뉴의 갯수 리스트 
     * </pre>
     * @Method Name : selectUprMenuCnt
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
     * @return
     * @throws Exception
     */ 	
    public int selectUprMenuCnt(MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 하위 메뉴 등록 창에서 입력한 데이터가 메뉴로 등록
     * 2. 처리내용 : 하위 메뉴 등록 창에서 입력한 데이터가 메뉴로 등록
     * </pre>
     * @Method Name : insertMenu
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
     * @throws Exception
     */ 	
    public void insertMenu(MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 선택된 메뉴의 맵핑이 되지않은 포탈관리 권한의 권한리스트 목록
     * 2. 처리내용 : 선택된 메뉴의 맵핑이 되지않은 포탈관리 권한의 권한리스트 목록
     * </pre>
     * @Method Name : selectRolePopList
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
     * @return
     * @throws Exception
     */ 	
    public List<MenuMng> selectRolePopList (MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 현재 메뉴의 맵핑된 권한 리스트 
     * 2. 처리내용 : 현재 메뉴의 맵핑된 권한 리스트 
     * </pre>
     * @Method Name : selectRoleMappList
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
     * @return
     * @throws Exception
     */ 	
    public List<AthrMng> selectRoleMappList (MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 선택한 메뉴와 권한을 맵핑하여 등록및 삭제 
     * 2. 처리내용 : 선택한 메뉴와 권한을 맵핑하여 등록및 삭제 
     * </pre>
     * @Method Name : saveRoleMapp
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
     * @throws Exception
     */ 	
    public void saveRoleMapp(MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 메뉴의 수정창에서 입력한 데이터를 업데이트
     * 2. 처리내용 : 메뉴의 수정창에서 입력한 데이터를 업데이트
     * </pre>
     * @Method Name : updateMenu
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
     * @throws Exception
     */ 	
    public void updateMenu(MenuMng menuVO) throws Exception;

    /**
     * <pre>
     * 1. 개요 : 선택한 메뉴를 삭제 하며 그 메뉴에 맵핑된 권한도 삭제 , 동 레벨 그룹의 메뉴를 다시 재정렬
     * 2. 처리내용 : 선택한 메뉴를 삭제 하며 그 메뉴에 맵핑된 권한도 삭제 , 동 레벨 그룹의 메뉴를 다시 재정렬
     * </pre>
     * @Method Name : deleteMenu
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
     * @throws Exception
     */ 	
    public void deleteMenu(MenuMng menuVO) throws Exception;
    
    /**
     * <pre>
     * 1. 개요 : 레프트 메뉴 클릭 시 메뉴 경로 이력 등록
     * 2. 처리내용 : 레프트 메뉴 클릭 시 메뉴 경로 이력 등록
     * </pre>
     * @Method Name : menuStatsInsert
     * @date : 2016. 6. 21.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 21.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param menuStatsVO
     * @throws Exception
     */ 	
    public void menuStatsInsert(MenuStat menuStatsVO) throws Exception;

    /**
     * <pre>
     * 1. 개요 : 메뉴 차트
     * 2. 처리내용 : 메뉴 차트
     * </pre>
     * @Method Name : selectMenuChart
     * @date : 2016. 6. 21.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 21.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param menuStatsVO
     * @param model
     * @throws Exception
     */ 	
    public void selectMenuChart(MenuStat menuStatsVO, ModelMap model) throws Exception;
	
    /**
     * <pre>
     * 1. 개요 : 메뉴 차트 리스트
     * 2. 처리내용 : 메뉴 차트 리스트
     * </pre>
     * @Method Name : selectMenuChartList
     * @date : 2016. 6. 21.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 21.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param menuStatsVO
     * @param model
     * @throws Exception
     */ 	
    public void selectMenuChartList(MenuStat menuStatsVO, ModelMap model) throws Exception;
    
    public Map<String, Object> menuChartListExcelDownload(MenuStat menuStatsVO) throws Exception;
}
