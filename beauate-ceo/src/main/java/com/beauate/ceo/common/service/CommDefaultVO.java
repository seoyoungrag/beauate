package com.beauate.ceo.common.service;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CommDefaultVO implements Serializable {
	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";
	
	/** 검색KeywordFrom */
	private String searchKeywordFrom = "";
	
	/** 검색KeywordTo */
	private String searchKeywordTo = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 등록자 아이디 */
	private String reg_id;
	
	/** 등록자 명 */
	private String reg_nm;
	
	/** 등록일자 */
	private String reg_de;
	
	/** 등록일자 */
	private String reg_de_str;

	/** 수정자 아이디 */
	private String mod_id;

	/** 수정일자 */
	private Date mod_dt;

	public String getMod_id() {
		return mod_id;
	}

	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}

	public Date getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(Date mod_dt) {
		this.mod_dt = mod_dt;
	}

	/** 사용자 로그인 아이디 */
	private String login_id;

	/** 사용자 아이디 */
	private String user_id;
	
	/** 사용자 명 */
	private String user_nm;
	
	/** 정렬조건 */
	private String sortSubject;

	/** 정렬방식 */
	private String sortDescend;

	/** 메뉴에 따른 권한 아이디 r(읽기) w(등록) z(관리) */
	private String menuRlDiv;
	
	/** 권한 아이디 */
	private String athr_id;
	/** 권한 명*/
	private String athr_name;
	
	/** 권한 매핑 아이디 */
	private String mapng_id;

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}

	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}


	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_nm() {
		return reg_nm;
	}

	public void setReg_nm(String reg_nm) {
		this.reg_nm = reg_nm;
	}

	public String getReg_de() {
		return reg_de;
	}

	public void setReg_de(String reg_de) {
		this.reg_de = reg_de;
	}

	public String getReg_de_str() {
		return reg_de_str;
	}

	public void setReg_de_str(String reg_de_str) {
		this.reg_de_str = reg_de_str;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getSortSubject() {
		return sortSubject;
	}

	public void setSortSubject(String sortSubject) {
		this.sortSubject = sortSubject;
	}

	public String getSortDescend() {
		return sortDescend;
	}

	public void setSortDescend(String sortDescend) {
		this.sortDescend = sortDescend;
	}

	public String getMenuRlDiv() {
		return menuRlDiv;
	}

	public void setMenuRlDiv(String menuRlDiv) {
		this.menuRlDiv = menuRlDiv;
	}

	public String getAthr_id() {
		return athr_id;
	}

	public void setAthr_id(String athr_id) {
		this.athr_id = athr_id;
	}

	public String getAthr_name() {
		return athr_name;
	}

	public void setAthr_name(String athr_name) {
		this.athr_name = athr_name;
	}

	public String getMapng_id() {
		return mapng_id;
	}

	public void setMapng_id(String mapng_id) {
		this.mapng_id = mapng_id;
	}
}
