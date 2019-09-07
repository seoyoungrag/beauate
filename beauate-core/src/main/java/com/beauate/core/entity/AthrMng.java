package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.beauate.core.common.CommDefaultVO;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ATHR_MNG database table.
 * 
 */
@Entity
@Table(name="ATHR_MNG")
@NamedQuery(name="AthrMng.findAll", query="SELECT a FROM AthrMng a")
public class AthrMng extends CommDefaultVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ATHR_ID", unique=true, nullable=false)
	private int athrId;

	@Column(name="ATHR_CD", length=20)
	private String athrCd;

	@Column(name="ATHR_CL", length=1)
	private String athrCl;

	@Column(name="ATHR_CN", length=200)
	private String athrCn;

	@Column(name="ATHR_NM", length=30)
	private String athrNm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REG_DE")
	private Date regDe;

	@Column(name="REG_ID", length=35)
	private String regId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDT_DE")
	private Date updtDe;

	@Column(name="UPDT_ID", length=35)
	private String updtId;

	//bi-directional many-to-many association to BeutyUser
	@ManyToMany(mappedBy="athrMngs")
	private List<BeutyUser> beutyUsers;

	//bi-directional many-to-many association to MenuMng
	@ManyToMany(mappedBy="athrMngs")
	private List<MenuMng> menuMngs;

	@Transient
	private String userIdsForSave;
	
	public AthrMng() {
	}

	public int getAthrId() {
		return this.athrId;
	}

	public void setAthrId(int athrId) {
		this.athrId = athrId;
	}

	public String getAthrCd() {
		return this.athrCd;
	}

	public void setAthrCd(String athrCd) {
		this.athrCd = athrCd;
	}

	public String getAthrCl() {
		return this.athrCl;
	}

	public void setAthrCl(String athrCl) {
		this.athrCl = athrCl;
	}

	public String getAthrCn() {
		return this.athrCn;
	}

	public void setAthrCn(String athrCn) {
		this.athrCn = athrCn;
	}

	public String getAthrNm() {
		return this.athrNm;
	}

	public void setAthrNm(String athrNm) {
		this.athrNm = athrNm;
	}

	public Date getRegDe() {
		return this.regDe;
	}

	public void setRegDe(Date regDe) {
		this.regDe = regDe;
	}

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getUpdtDe() {
		return this.updtDe;
	}

	public void setUpdtDe(Date updtDe) {
		this.updtDe = updtDe;
	}

	public String getUpdtId() {
		return this.updtId;
	}

	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}

	public List<BeutyUser> getBeutyUsers() {
		return this.beutyUsers;
	}

	public void setBeutyUsers(List<BeutyUser> beutyUsers) {
		this.beutyUsers = beutyUsers;
	}

	public List<MenuMng> getMenuMngs() {
		return this.menuMngs;
	}

	public void setMenuMngs(List<MenuMng> menuMngs) {
		this.menuMngs = menuMngs;
	}

	public String getUserIdsForSave() {
		return userIdsForSave;
	}

	public void setUserIdsForSave(String userIdsForSave) {
		this.userIdsForSave = userIdsForSave;
	}
	
	

}