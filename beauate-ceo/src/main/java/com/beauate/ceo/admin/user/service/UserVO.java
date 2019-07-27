package com.beauate.ceo.admin.user.service;

import java.io.Serializable;
import java.util.Date;

import com.beauate.ceo.common.service.CommDefaultVO;

@SuppressWarnings("serial")
public class UserVO extends CommDefaultVO implements Serializable {
	/** 사용자 패스워드 */
	private String user_pw;
	/** 사용자 영문이름 */
	private String user_eng_nm;
	/** 사용자 번호 */
	private String pno;
	/** 사용자 핸드폰번호 */
	private String mbl_pno;
	/** 사용자 팩스번호 */
	private String fax_no;
	/** 사용자 우편번호*/
	private String zip_no;
	/** 사용자 주소 */
	private String addr;
	/** 사용자 이메일 */
	private String email_addr;
	/** 사용자 삭제여부 */
	private String del_yn;
	/** 가입일 */
	private Date join_dt;
	public Date getJoin_dt() {
		return join_dt;
	}
	public void setJoin_dt(Date join_dt) {
		this.join_dt = join_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_eng_nm() {
		return user_eng_nm;
	}
	public void setUser_eng_nm(String user_eng_nm) {
		this.user_eng_nm = user_eng_nm;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getMbl_pno() {
		return mbl_pno;
	}
	public void setMbl_pno(String mbl_pno) {
		this.mbl_pno = mbl_pno;
	}
	public String getFax_no() {
		return fax_no;
	}
	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}
	public String getZip_no() {
		return zip_no;
	}
	public void setZip_no(String zip_no) {
		this.zip_no = zip_no;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail_addr() {
		return email_addr;
	}
	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}
}
