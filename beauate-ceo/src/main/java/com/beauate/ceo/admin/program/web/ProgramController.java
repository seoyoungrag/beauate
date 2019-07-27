package com.beauate.ceo.admin.program.web;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.beauate.ceo.admin.program.service.ProgramService;
import com.beauate.ceo.admin.program.service.ProgramVO;
import com.beauate.ceo.login.service.LoginVO;

@Controller
public class ProgramController {
	protected Log log = LogFactory.getLog(this.getClass());

	@Resource(name = "programService")
	private ProgramService programService;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 리스트
	 * 2. 처리내용 : 프로그램관리 리스트
	 * </pre>
	 * @Method Name : selectProgramList
	 * @date : 2016. 11. 12.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자				변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 11. 12.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @param model
	 * @return String
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/program/z/m/selectProgramList.do")
	public String selectProgramList(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model) throws Exception {
		programService.selectProgramList(programVO, model);
		return "/admin/program/programList";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 등록하는 화면
	 * 2. 처리내용 : 프로그램 등록하는 화면
	 * </pre>
	 * @Method Name : insertProgram
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
	@RequestMapping(value = "/program/z/m/insertProgram.do")
	public String insertProgram(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model) throws Exception {
		return "/admin/program/programInsert";
	}
	
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
	@RequestMapping(value = "/program/z/n/selectProgramParamChk.do")
	public String selectProgramParamChk(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model) throws Exception {
		log.debug(">>> Before pgmParamChk : " + model);
		programService.selectProgramParamChk(programVO, model);
		log.debug(">>> Afer pgmParamChk : " + model);
		return "jsonView";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 등록화면에서 입력한 정보를 등록
	 * 2. 처리내용 : 프로그램 등록화면에서 입력한 정보를 등록
	 * </pre>
	 * @Method Name : insertProgramProc
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
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return String
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/program/z/n/insertProgramProc.do")
	public String insertProgramProc(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model, SessionStatus status, LoginVO sessionVO) throws Exception {
		log.debug(">>> Befor insertProgramProc : " + model);

		programVO.setLogin_id("mong");
//		programVO.setLogin_id(sessionVO.getLogin_id());
		programService.insertProgramProc(programVO);
		status.setComplete();	//중복 submit 방지
		
		log.debug(">>> After insertProgramProc, model : " + model);
		log.debug(">>> After insertProgramProc, programVO : " + programVO);
		
		return "redirect:/program/z/m/selectProgramList.do";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 상세 조회
	 * 2. 처리내용 : 프로그램 상세 조회
	 * </pre>
	 * @Method Name : selectProgram
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
	@RequestMapping(value = "/program/z/m/selectProgramDetail.do")
	public String selectProgramDetal(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model) throws Exception {
		log.debug(">>> before selectProgram : " + programVO);
		programService.selectProgramDetail(programVO, model);
		log.debug(">>> Afer selectProgram : " + model);
		return "/admin/program/programDetail";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 수정 화면
	 * 2. 처리내용 : 프로그램 수정 화면
	 * </pre>
	 * @Method Name : updateProgram
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
	@RequestMapping(value = "/program/z/m/updateProgram.do")
	public String updateProgram(@ModelAttribute("programVO") ProgramVO programVO, ModelMap model) throws Exception {
		log.debug(">>> Before updateProgram, model : " + model);
		programService.selectProgramDetail(programVO, model);
		log.debug(">>> After updateProgram, model : " + model);
		
		return "/admin/program/programUpdate";
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 수정화면에서 변경된 정보를 수정
	 * 2. 처리내용 : 프로그램 수정화면에서 변경된 정보를 수정
	 * </pre>
	 * @Method Name : updateProgramProc
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
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return String
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/program/z/n/updateProgramProc.do")
	public String updateProgramProc(@ModelAttribute("programVO") ProgramVO programVO, SessionStatus status, ModelMap model, LoginVO sessionVO) throws Exception {
		log.debug(">>> Before updateProgramProc, model : " + model);
		log.debug(">>> Before updateProgramProc, programVO : " + programVO);
		
//		programVO.setLogin_id(sessionVO.getLogin_id());
//		programVO.setMenuRlDiv(sessionVO.getMenuRlDiv());
		programVO.setLogin_id("mong");
		programService.updateProgramProc(programVO);
		status.setComplete();	//중복 submit 방지
		
		log.debug(">>> After updateProgramProc, model : " + model);
		log.debug(">>> After updateProgramProc, programVO : " + programVO);
		
		return "redirect:/program/z/m/selectProgramDetail.do?prgr_id=" + programVO.getPrgr_id();
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 등록된 프로그램 삭제
	 * 2. 처리내용 : 선택한 프로그램 상세목록에서의 선택한 프로그램 삭제 기능
	 * </pre>
	 * @Method Name : deleteProgramProc
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
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return String
	 * @throws Exception
	 */ 	
	@RequestMapping(value = "/program/z/n/deleteProgramProc.do")
	public String deleteProgramProc(@ModelAttribute("programVO") ProgramVO programVO, SessionStatus status, ModelMap model, LoginVO sessionVO) throws Exception {
		log.debug(">>> Before deleteProgramProc, model : " + model);
		log.debug(">>> Before deleteProgramProc, programVO : " + programVO);

//		programVO.setLogin_id(sessionVO.getLogin_id());
//		programVO.setMenuRlDiv(sessionVO.getMenuRlDiv());
		programVO.setLogin_id("mong");
		
		// 프로그램삭제, 메뉴에 맵핑되어있는 프로그램 아이디도 null 업데이트
		programService.deleteProgramProc(programVO);
		status.setComplete();	//중복 submit 방지
		
		log.debug(">>> After deleteProgramProc, model : " + model);
		log.debug(">>> After deleteProgramProc, programVO : " + programVO);
		
		return "redirect:/program/z/m/selectProgramList.do";
	}
}
