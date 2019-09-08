package com.beauate.ceo.login.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;

@SuppressWarnings("serial")
public class LoginVO extends BeutyUser implements Serializable {
	 /** 포탈관리자 */
	private String portalAdmin;
	/** 상단의 포탈관리 버튼 */
	private String portalManageGunbun;
	
	private List<AthrMng> roleList = new ArrayList<AthrMng>();
//    
//	private ArrayList<RoleVO> roleList = new ArrayList<RoleVO>(); 
//    private ArrayList<RoleVO> ifmsRoleList = new ArrayList<RoleVO>();
//    private List<MenuMng> userMenu = new ArrayList<MenuMng>();
//    private List<MenuMng> tabMenu = new ArrayList<MenuMng>();
//    private List<String> checkTab = new ArrayList<String>();
//    private String query;
	
	
	public String getPortalAdmin() {
		return portalAdmin;
	}
	public List<AthrMng> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<AthrMng> roleList) {
		this.roleList = roleList;
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
