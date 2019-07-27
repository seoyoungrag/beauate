package com.beauate.ceo.admin.program.service;

import java.io.Serializable;

import com.beauate.ceo.common.service.CommDefaultVO;

@SuppressWarnings("serial")
public class ProgramVO extends CommDefaultVO implements Serializable {
	/** 프로그램 아이디 */
	private String prgr_id;
	/** 프로그램 이름 */
	private String prgr_nm;
	/** 프로그램의 URL주소 */
	private String prgr_url;
	/** 프로그램에 대한 설명 */
	private String prgr_cn;
	/** 프로그램 과 실제 class 간에 연관 변수값 */
	private String prgr_vriabl;
	/** 프로그램 메뉴 맵핑시 구분 값 (Y일때 프로그램 맵핑)  */
	private String pgmGubun;
	/** 메뉴에 따른 권한 아이디 r(읽기) w(등록) z(관리)  */
	private String menuRlDiv;
	
	public String getPrgr_id() {
		return prgr_id;
	}
	public void setPrgr_id(String prgr_id) {
		this.prgr_id = prgr_id;
	}
	public String getPrgr_nm() {
		return prgr_nm;
	}
	public void setPrgr_nm(String prgr_nm) {
		this.prgr_nm = prgr_nm;
	}
	public String getPrgr_url() {
		return prgr_url;
	}
	public void setPrgr_url(String prgr_url) {
		this.prgr_url = prgr_url;
	}
	public String getPrgr_cn() {
		return prgr_cn;
	}
	public void setPrgr_cn(String prgr_cn) {
		this.prgr_cn = prgr_cn;
	}
	public String getPrgr_vriabl() {
		return prgr_vriabl;
	}
	public void setPrgr_vriabl(String prgr_vriabl) {
		this.prgr_vriabl = prgr_vriabl;
	}
	public String getPgmGubun() {
		return pgmGubun;
	}
	public void setPgmGubun(String pgmGubun) {
		this.pgmGubun = pgmGubun;
	}
	public String getMenuRlDiv() {
		return menuRlDiv;
	}
	public void setMenuRlDiv(String menuRlDiv) {
		this.menuRlDiv = menuRlDiv;
	}
}
