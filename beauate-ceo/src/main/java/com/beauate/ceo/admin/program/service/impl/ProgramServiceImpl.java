package com.beauate.ceo.admin.program.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.beauate.ceo.admin.program.service.ProgramService;
import com.beauate.ceo.admin.program.service.ProgramVO;
import com.beauate.core.entity.PrgrMng;
import com.beauate.core.repository.PrgrMngRepository;

@Service("programService")
public class ProgramServiceImpl implements ProgramService {
	protected Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private PrgrMngRepository prgrMngRepository;
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 리스트
	 * 2. 처리내용 : 프로그램관리 리스트
	 * </pre>
	 * @Method Name : selectProgramList
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.  		신호석			                    최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */ 	
	public void selectProgramList(ProgramVO programVO, ModelMap model) throws Exception {
		/* 실제로는 쓰이지 않음.
		if(programVO.getPgmGubun()!=null&&!programVO.getPgmGubun().equals("")&&programVO.getPgmGubun().equals("Y")) {
			
		}
		*/
		Pageable pageable = PageRequest.of(1, 10);
		Page<PrgrMng> selectList = null;
		if(programVO.getSearchKeyword()!=null && programVO.getSearchCondition()!=null) {
			if(programVO.getSearchCondition().equals("prgr_nm")) {
			    selectList = prgrMngRepository.findByPrgrNmIgnoreCaseContaining(programVO.getSearchKeyword(), pageable);
			}else if(programVO.getSearchCondition().equals("prgr_vriabl")) {
			    selectList = prgrMngRepository.findByPrgrVriablIgnoreCaseContaining(programVO.getSearchKeyword(), pageable);
			}
		}
		//총 카운트 
		long cnt = selectList.getTotalElements();
		
		model.addAttribute("programList", selectList);
		model.addAttribute("programListCnt", cnt);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램 등록시 프로그램 변수 중복 검사
	 * 2. 처리내용 : 프로그램 등록시 프로그램 변수 중복 검사
	 * </pre>
	 * @Method Name : selectProgramParamChk
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */ 	
	public void selectProgramParamChk(ProgramVO programVO, ModelMap model) throws Exception {
		long cnt = 0;
		Pageable pageable = PageRequest.of(1, 10);
		if(programVO.getPrgr_id()!=null) {
			cnt = prgrMngRepository.findByPrgrVriablIgnoreCaseAndPrgrIdNot(programVO.getPrgr_vriabl(), programVO.getPrgr_id(), pageable).getTotalElements();
		}else {
			cnt = prgrMngRepository.findByPrgrVriablIgnoreCase(programVO.getPrgr_vriabl(), pageable).getTotalElements();
		}
		log.debug(">>>After pgmParamChk Impl : " + cnt);
		//프로그램 변수가 중복(cnt>0)을 경우 chkResult값을 'N', 중복이 아니면 'Y'로 한다
		model.addAttribute("chkResult", (cnt > 0) ? "N" : "Y");
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 등록 한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 등록 한다 
	 * </pre>
	 * @Method Name : insertProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일			작성자					변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.  신호석			 	          최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */ 	
	public void insertProgramProc(ProgramVO programVO) throws Exception {
		log.debug(">>> programVO in insertProgram impl : " + programVO);
		//programDao.insertProgramProc(programVO);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 선택된 프로그램 상세정보를 가져온다.
	 * 2. 처리내용 : 선택된 프로그램 상세정보를 가져온다.
	 * </pre>
	 * @Method Name : selectProgramDetail
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일					작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.		신호석				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */ 	
	public void selectProgramDetail(ProgramVO programVO, ModelMap model) throws Exception {
		model.addAttribute("resultVO", prgrMngRepository.findById(programVO.getPrgr_id()).get());
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 수정한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 수정한다 
	 * </pre>
	 * @Method Name : updateProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일		         	 작성자				          변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.			신호석				           최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */ 	
	public void updateProgramProc(ProgramVO programVO) throws Exception {
		log.debug(">>> updateProgramProc serviceImpl");
		//programDao.updateProgramProc(programVO);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 프로그램관리 프로그램을 삭제한다 
	 * 2. 처리내용 :  프로그램관리 프로그램을 삭제한다 
	 * </pre>
	 * @Method Name : deleteProgramProc
	 * @date : 2019. 7. 21.
	 * @author : 신호석
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일		         	 작성자				          변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 7. 21.			신호석				           최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param programVO
	 * @return void
	 * @throws Exception
	 */
	public void deleteProgramProc(ProgramVO programVO) throws Exception {
		// 메뉴랑 연결된 프로그램이 있는지 확인
//		int relatedMenuCnt = programMapper.selectProgramRelatedMenuCnt(programVO);
		// 연결되어 있는 항목이 있을 경우 메뉴테이블에 맵핑되어 있는 ID를 null 처리한다 -> 외래키 참조 해제
//		if(relatedMenuCnt > 0) {
//			programMapper.updatePgmIdMenu(programVO);
//		}
		
		//int delResult = programDao.deleteProgramProc(programVO);
		//log.debug(">>> deleteProgram serviceImpl"+ delResult);
	}
}
