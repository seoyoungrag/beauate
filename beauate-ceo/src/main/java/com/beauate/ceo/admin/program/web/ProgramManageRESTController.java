package com.beauate.ceo.admin.program.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauate.ceo.admin.program.service.ProgramManageService;
import com.beauate.core.entity.PrgrMng;

@RestController
public class ProgramManageRESTController {
	protected Log log = LogFactory.getLog(this.getClass());

	@Resource(name = "programService")
	private ProgramManageService programService;

	/**
	 * <pre>
	 * 1. 개요 : 프로그램 변수가 중복여부 검사
	 * 2. 처리내용 : 프로그램 변수가 중복여부 검사
	 * </pre>
	 * @Method Name : pgmParamChk
	 * @date : 2019. 07. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자				변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 07. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @param model
	 * @return String
	 * @throws Exception
	 */ 	
	@PostMapping(value = "/program/z/n/selectProgramParamChk.do")
	public Map selectProgramParamChk(@ModelAttribute("programVO") PrgrMng programVO, ModelMap model) throws Exception {
		log.debug(">>> Before pgmParamChk : " + model);
		long cnt = programService.selectProgramParamChk(programVO, model);
		log.debug(">>> Afer pgmParamChk : " + model);
    	Map<String, Object> rtnMap = new HashMap<String,Object>();
    	rtnMap.put("chkResult", (cnt > 0) ? "N" : "Y");
        return rtnMap;
	}
	
	
}
