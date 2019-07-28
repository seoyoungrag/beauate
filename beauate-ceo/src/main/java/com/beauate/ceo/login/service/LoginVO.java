package com.beauate.ceo.login.service;

import java.io.Serializable;

import com.beauate.ceo.admin.user.service.UserVO;

@SuppressWarnings("serial")
public class LoginVO extends UserVO implements Serializable {
	 /** 포탈관리자 */
	private String portalAdmin;
	/** 상단의 포탈관리 버튼 */
	private String portalManageGunbun;
//    
//	private ArrayList<RoleVO> roleList = new ArrayList<RoleVO>(); 
//    private ArrayList<RoleVO> ifmsRoleList = new ArrayList<RoleVO>();
//    private List<MenuVO> userMenu = new ArrayList<MenuVO>();
//    private List<MenuVO> tabMenu = new ArrayList<MenuVO>();
//    private List<String> checkTab = new ArrayList<String>();
//    private String query;
	public String getPortalAdmin() {
		return portalAdmin;
	}
	public void setPortalAdmin(String portalAdmin) {
		this.portalAdmin = portalAdmin;
	}
	public String getPortalManageGunbun() {
		return portalManageGunbun;
	}
	public void setPortalManageGunbun(String portalManageGunbun) {
		this.portalManageGunbun = portalManageGunbun;
	}
}
