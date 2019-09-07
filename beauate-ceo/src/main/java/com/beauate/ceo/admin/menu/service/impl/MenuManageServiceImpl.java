package com.beauate.ceo.admin.menu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.menu.service.MenuManageService;
import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.MenuMng;
import com.beauate.core.entity.MenuStat;
import com.beauate.core.repository.AthrMngRepository;
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
	
	@Autowired
	private AthrMngRepository athrMngRepository;
    
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
    
    /**
     * <pre>
     * 1. 개요 :  선택된 메뉴의 상세 정보 와 그 메뉴의 권한맵핑 목록 리스트 
     * 2. 처리내용 :  선택된 메뉴의 상세 정보 와 그 메뉴의 권한맵핑 목록 리스트 
     * </pre>
     * @Method Name : selectMenu
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectMenu(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @return
     * @throws Exception
     */ 	
    @Override
    public MenuMng selectMenu(MenuMng menuVO) throws Exception{
        return menuMngRepository.findById(menuVO.getMenuId()).get();
    }
    
    /**
     * <pre>
     * 1. 개요 : 정렬을 위한 메뉴의 갯수 리스트
     * 2. 처리내용 : 정렬을 위한 메뉴의 갯수 리스트
     * </pre>
     * @Method Name : selectUprMenuCnt
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectUprMenuCnt(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @return
     * @throws Exception
     */ 	
    @Override
    public int selectUprMenuCnt(MenuMng menuVO) throws Exception{
    	List<MenuMng> childMenuList = menuMngRepository.findAllByUpperMenuId(menuVO.getUpperMenuId()); 
        return childMenuList.size();
    }
    
    /**
     * <pre>
     * 1. 개요 : 하위 메뉴 등록 창에서 입력한 데이터가 메뉴로 등록
     * 2. 처리내용 : 하위 메뉴 등록 창에서 입력한 데이터가 메뉴로 등록
     * </pre>
     * @Method Name : insertMenu
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#insertMenu(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @throws Exception
     */ 	
    @Override
    public void insertMenu(MenuMng menuVO) throws Exception{
    	
        //메뉴 추가
    	//menuMngRepository.save(menuVO);
        
        //정렬값 변경이면 업데이트도 변행해야함
        menuVO.setMenuSort(menuVO.getMenuSort()+1);
        menuMngRepository.save(menuVO);
        
    }
    
    /**
     * <pre>
     * 1. 개요 : 선택된 메뉴의 맵핑이 되지않은 포탈관리 권한의 권한리스트 목록
     * 2. 처리내용 : 선택된 메뉴의 맵핑이 되지않은 포탈관리 권한의 권한리스트 목록
     * </pre>
     * @Method Name : selectRolePopList
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectRolePopList(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @return
     * @throws Exception
     */ 	
    @Override
    public List<MenuMng> selectRolePopList (MenuMng menuVO) throws Exception{
        /*
        //관리자용 메뉴에서 권한을 맵핑할때에는 포탈 관리 권한으로 등록된 권한그룹리스트만을 보여줌
        if("2".equals(menuVO.getMenuDiv())){
            menuVO.setRlCls("A");
        }
        
        return menuMapper.selectRolePopList(menuVO);
        */
    	return null;
    }
    
    /**
     * <pre>
     * 1. 개요 : 현재 메뉴의 맵핑된 권한 리스트 
     * 2. 처리내용 : 현재 메뉴의 맵핑된 권한 리스트 
     * </pre>
     * @Method Name : selectRoleMappList
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectRoleMappList(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @return
     * @throws Exception
     */ 	
    @Override
    public List<AthrMng> selectRoleMappList (MenuMng menuVO) throws Exception{

        // 권한 맵핑 리스트
        MenuMng menu = this.selectMenu(menuVO);

        // 권한 목록 리스트
        List<AthrMng> allRolePopList = athrMngRepository.findAll();
        List<AthrMng> rolePopList = new ArrayList<AthrMng>();
        for(AthrMng athr : allRolePopList) {
        	for(AthrMng menuAthr : menu.getAthrMngs()) {
        		if(menuAthr.getAthrId() != athr.getAthrId()) {
        			rolePopList.add(athr);
        		}
        	}
        }
        return rolePopList;
    }
    
    /**
     * <pre>
     * 1. 개요 : 선택한 메뉴와 권한을 맵핑하여 등록및 삭제 
     * 2. 처리내용 : 선택한 메뉴와 권한을 맵핑하여 등록및 삭제 
     * </pre>
     * @Method Name : saveRoleMapp
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#saveRoleMapp(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @throws Exception
     */ 	
    @Override
    public void saveRoleMapp(MenuMng menuVO) throws Exception{
    	Optional<MenuMng> menuOp = menuMngRepository.findById(menuVO.getMenuId());
    	MenuMng menu = menuOp.get();
    	menu.setAthrMngs(menuVO.getAthrMngs());
    	menuMngRepository.save(menu);
        /*
        //메뉴와 권한 맵핑 추가 
        List<MenuMng> roleMappList = menuVO.getRoleMappList();
        MenuMng tempVO;
        
        if(roleMappList != null){
        	//삭제
            menuMapper.deleteRoleMappList(menuVO);
            
            for (int i = 0; i < roleMappList.size(); i++) {
                tempVO = new MenuMng();
                tempVO = roleMappList.get(i);
                
                tempVO.setMppgId(mnRlMappingIdGnrService.getNextStringId());
                tempVO.setMenuId(menuVO.getMenuId());
                tempVO.setRgId(menuVO.getRgId());
                
                //등록
                menuMapper.insertRoleMappList(tempVO);
            }
        }
        */
    }
    
    /**
     * <pre>
     * 1. 개요 :  메뉴의 수정창에서 입력한 데이터를 업데이트
     * 2. 처리내용 :  메뉴의 수정창에서 입력한 데이터를 업데이트
     * </pre>
     * @Method Name : updateMenu
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#updateMenu(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @throws Exception
     */ 	
    @Override
    public void updateMenu(MenuMng menuVO) throws Exception{
        
        //정렬값이 변하지 않는 경우 그냥 현재 메뉴 업데이트
        if(menuVO.getPreMenuSort() == menuVO.getMenuSort()){
        	menuMngRepository.save(menuVO);
        }
        //정렬값이 변한 경우에는 같은 부모를 가지고 있는 동레벨의 메뉴들의 정렬값을 update 해줘야함
        else{
        	List<MenuMng> menuList = menuMngRepository.findAllByUpperMenuId(menuVO.getMenuId());
        	for(MenuMng menu : menuList) {
        		if(menu.getMenuSort() >= menuVO.getMenuSort()) {
            		menu.setMenuSort(menu.getMenuSort()+1);
        		}
        	}
        	menuMngRepository.saveAll(menuList);
        	menuMngRepository.save(menuVO);
        }
    } 

    /**
     * <pre>
     * 1. 개요 : 선택한 메뉴를 삭제 하며 그 메뉴에 맵핑된 권한도 삭제 , 동 레벨 그룹의 메뉴를 다시 재정렬
     * 2. 처리내용 : 선택한 메뉴를 삭제 하며 그 메뉴에 맵핑된 권한도 삭제 , 동 레벨 그룹의 메뉴를 다시 재정렬
     * </pre>
     * @Method Name : deleteMenu
     * @date : 2016. 6. 24.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 24.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#deleteMenu(kr.co.enkiadmin.admin.menu.service.MenuMng)
     * @param menuVO
     * @throws Exception
     */ 	
    @Override
    public void deleteMenu(MenuMng menuVO) throws Exception{
    	List<MenuMng> menuList = menuMngRepository.findAllByUpperMenuId(menuVO.getMenuId());
    	for(MenuMng menu : menuList) {
    		if(menu.getMenuSort() > menuVO.getMenuSort()) {
        		menu.setMenuSort(menu.getMenuSort()-1);
    		}
    	}
    	menuMngRepository.saveAll(menuList);
    	menuMngRepository.delete(menuVO);
    }
    
    /**
     * <pre>
     * 1. 개요 : 레프트 메뉴 클릭 시 메뉴 경로 이력 등록
     * 2. 처리내용 : 레프트 메뉴 클릭 시 메뉴 경로 이력 등록
     * </pre>
     * @Method Name : routeHistory
     * @date : 2016. 6. 21.
     * @author : 양태욱
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 6. 21.		양태욱				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#routeHistory(kr.co.enkiadmin.admin.menu.service.MenuStat)
     * @param menuStatsVO
     * @throws Exception
     */ 	
    @Override
    public void menuStatsInsert(MenuStat menuStatsVO) throws Exception{
		//menuMapper.menuStatsInsert(menuStatsVO);
	}

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
	 * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectMenuChart(kr.co.enkiadmin.admin.menu.service.MenuStat, org.springframework.ui.ModelMap)
	 * @param menuStatsVO
	 * @param model
	 * @throws Exception
	 */ 	
	@Override
	public void selectMenuChart(MenuStat menuStatsVO, ModelMap model) throws Exception {
		/*
		if("".equals(StringUtil.nvl(menuStatsVO.getStartDate()))){
			String curTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			menuStatsVO.setStartDate(curTime);
			menuStatsVO.setEndDate(curTime);
		}
		
    	List<EgovMap> menuStatsChart = menuMapper.selectMenuChart(menuStatsVO);
    	Gson gson = new Gson();
    	String menuStatsChartJson = gson.toJson(menuStatsChart);
    	
    	model.addAttribute("menuStatsChartJson", menuStatsChartJson);
    	*/
	}

	/**
	 * <pre>
	 * 1. 개요 :  메뉴 차트 리스트
	 * 2. 처리내용 :  메뉴 차트 리스트
	 * </pre>
	 * @Method Name : selectMenuChartList
	 * @date : 2016. 6. 22.
	 * @author : 양태욱
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 6. 22.		양태욱				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#selectMenuChartList(kr.co.enkiadmin.admin.menu.service.MenuStat, org.springframework.ui.ModelMap)
	 * @param menuStatsVO
	 * @param model
	 * @return
	 * @throws Exception
	 */ 	
	@Override
	public void selectMenuChartList(MenuStat menuStatsVO, ModelMap model) throws Exception {
		/*
		//페이징 
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(menuStatsVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(menuStatsVO.getPageUnit());
        paginationInfo.setPageSize(menuStatsVO.getPageSize());
        
        menuStatsVO.setFirstIndex(paginationInfo.getFirstRecordIndex()+1); 
        menuStatsVO.setLastIndex(paginationInfo.getLastRecordIndex());
        menuStatsVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<EgovMap> selectList = null;
        
        // 현재 날짜 세팅
		if("".equals(StringUtil.nvl(menuStatsVO.getStartDate()))){
			String curTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			menuStatsVO.setStartDate(curTime);
			menuStatsVO.setEndDate(curTime);
		}
		
        int cnt = menuMapper.selectMenuChartListCnt(menuStatsVO);
        paginationInfo.setTotalRecordCount(cnt);
        
        if(cnt > 0){
            if(null == menuStatsVO.getSortSubject()){
            	menuStatsVO.setSortSubject("visitDate");
            	menuStatsVO.setSortDescend("desc");
            }
        	selectList = menuMapper.selectMenuChartList(menuStatsVO);
        }
        
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("menuChartListCnt", cnt);
        model.addAttribute("menuChartList", selectList);
        */
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 메뉴통계 리스트 엑셀 다운로드
	 * 2. 처리내용 : 메뉴통계 리스트 엑셀 다운로드
	 * </pre>
	 * @Method Name : menuChartListExcelDownload
	 * @date : 2016. 6. 24.
	 * @author : 양태욱
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 6. 24.		양태욱				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see kr.co.enkiadmin.admin.menu.service.MenuManageService#menuChartListExcelDownload(kr.co.enkiadmin.admin.menu.service.MenuStat)
	 * @param menuStatsVO
	 * @return
	 * @throws Exception
	 */ 	
	public Map<String, Object> menuChartListExcelDownload(MenuStat menuStatsVO) throws Exception {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		/*
		// 엑셀 다운로드 페이징 없애기 위해 값 세팅
        menuStatsVO.setFirstIndex(1); 
        menuStatsVO.setLastIndex(99999999);
		
        List<EgovMap> selectList = null;
        
        // 현재 날짜 세팅
		if("".equals(StringUtil.nvl(menuStatsVO.getStartDate()))){
			String curTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			menuStatsVO.setStartDate(curTime);
			menuStatsVO.setEndDate(curTime);
		}
		
        int cnt = menuMapper.selectMenuChartListCnt(menuStatsVO);
        
        if(cnt > 0){
            if(null == menuStatsVO.getSortSubject()){
            	menuStatsVO.setSortSubject("visitDate");
            	menuStatsVO.setSortDescend("desc");
            }
        	selectList = menuMapper.selectMenuChartList(menuStatsVO);
        }
        
        rsltMap.put("menuChartListCnt", cnt);
        rsltMap.put("menuChartList", selectList);
        */
        return rsltMap;
	}
}
