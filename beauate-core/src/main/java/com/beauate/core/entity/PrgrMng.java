package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PRGR_MNG database table.
 * 
 */
@Entity
@Table(name="PRGR_MNG")
@NamedQuery(name="PrgrMng.findAll", query="SELECT p FROM PrgrMng p")
public class PrgrMng implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRGR_ID", unique=true, nullable=false)
	private int prgrId;

	@Column(name="PRGR_CN", length=200)
	private String prgrCn;

	@Column(name="PRGR_NM", length=30)
	private String prgrNm;

	@Column(name="PRGR_URL", length=50)
	private String prgrUrl;

	@Column(name="PRGR_VRIABL", length=20)
	private String prgrVriabl;

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

	//bi-directional many-to-one association to MenuMng
	@OneToMany(mappedBy="prgrMng")
	private List<MenuMng> menuMngs;

	public PrgrMng() {
	}

	public int getPrgrId() {
		return this.prgrId;
	}

	public void setPrgrId(int prgrId) {
		this.prgrId = prgrId;
	}

	public String getPrgrCn() {
		return this.prgrCn;
	}

	public void setPrgrCn(String prgrCn) {
		this.prgrCn = prgrCn;
	}

	public String getPrgrNm() {
		return this.prgrNm;
	}

	public void setPrgrNm(String prgrNm) {
		this.prgrNm = prgrNm;
	}

	public String getPrgrUrl() {
		return this.prgrUrl;
	}

	public void setPrgrUrl(String prgrUrl) {
		this.prgrUrl = prgrUrl;
	}

	public String getPrgrVriabl() {
		return this.prgrVriabl;
	}

	public void setPrgrVriabl(String prgrVriabl) {
		this.prgrVriabl = prgrVriabl;
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

	public List<MenuMng> getMenuMngs() {
		return this.menuMngs;
	}

	public void setMenuMngs(List<MenuMng> menuMngs) {
		this.menuMngs = menuMngs;
	}

	public MenuMng addMenuMng(MenuMng menuMng) {
		getMenuMngs().add(menuMng);
		menuMng.setPrgrMng(this);

		return menuMng;
	}

	public MenuMng removeMenuMng(MenuMng menuMng) {
		getMenuMngs().remove(menuMng);
		menuMng.setPrgrMng(null);

		return menuMng;
	}

}