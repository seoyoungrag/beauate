package com.beauate.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.beauate.core.common.CommDefaultVO;


/**
 * The persistent class for the MENU_MNG database table.
 * 
 */
@Entity
@Table(name="MENU_MNG")
@NamedQuery(name="MenuMng.findAll", query="SELECT m FROM MenuMng m")
public class MenuMng extends CommDefaultVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MENU_ID", unique=true, nullable=false)
	private int menuId;

	@Column(name="EXTRL_URL", length=50)
	private String extrlUrl;

	@Column(name="MENU_CN", length=200)
	private String menuCn;

	@Column(name="MENU_LV")
	private int menuLv;

	@Column(name="MENU_NM", length=30)
	private String menuNm;

	@Column(name="MENU_SE", length=1)
	private String menuSe;

	@Column(name="MENU_SORT")
	private int menuSort;

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

	@Column(name="UPPER_MENU_ID")
	private int upperMenuId;

	@Column(name="USE_YN", length=1)
	private String useYn;

	//bi-directional many-to-many association to AthrMng
	@ManyToMany
	@JoinTable(
		name="MENU_ATHR_MAPNG"
		, joinColumns={
			@JoinColumn(name="MENU_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ATHR_ID", nullable=false)
			}
		)
	private List<AthrMng> athrMngs;

	//bi-directional many-to-one association to MenuStat
	@OneToMany(mappedBy="menuMng", fetch=FetchType.EAGER)
	private List<MenuStat> menuStats;

	//bi-directional many-to-one association to PrgrMng
	@ManyToOne
	@JoinColumn(name="PRGR_ID")
	private PrgrMng prgrMng;
	
	@Transient
	private int preMenuSort;

	public MenuMng() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getExtrlUrl() {
		return this.extrlUrl;
	}

	public void setExtrlUrl(String extrlUrl) {
		this.extrlUrl = extrlUrl;
	}

	public String getMenuCn() {
		return this.menuCn;
	}

	public void setMenuCn(String menuCn) {
		this.menuCn = menuCn;
	}

	public int getMenuLv() {
		return this.menuLv;
	}

	public void setMenuLv(int menuLv) {
		this.menuLv = menuLv;
	}

	public String getMenuNm() {
		return this.menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuSe() {
		return this.menuSe;
	}

	public void setMenuSe(String menuSe) {
		this.menuSe = menuSe;
	}

	public int getMenuSort() {
		return this.menuSort;
	}

	public void setMenuSort(int menuSort) {
		this.menuSort = menuSort;
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

	public int getUpperMenuId() {
		return this.upperMenuId;
	}

	public void setUpperMenuId(int upperMenuId) {
		this.upperMenuId = upperMenuId;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public List<AthrMng> getAthrMngs() {
		return this.athrMngs;
	}

	public void setAthrMngs(List<AthrMng> athrMngs) {
		this.athrMngs = athrMngs;
	}

	public List<MenuStat> getMenuStats() {
		return this.menuStats;
	}

	public void setMenuStats(List<MenuStat> menuStats) {
		this.menuStats = menuStats;
	}

	public MenuStat addMenuStat(MenuStat menuStat) {
		getMenuStats().add(menuStat);
		menuStat.setMenuMng(this);

		return menuStat;
	}

	public MenuStat removeMenuStat(MenuStat menuStat) {
		getMenuStats().remove(menuStat);
		menuStat.setMenuMng(null);

		return menuStat;
	}

	public PrgrMng getPrgrMng() {
		return this.prgrMng;
	}

	public void setPrgrMng(PrgrMng prgrMng) {
		this.prgrMng = prgrMng;
	}

	public int getPreMenuSort() {
		return preMenuSort;
	}

	public void setPreMenuSort(int preMenuSort) {
		this.preMenuSort = preMenuSort;
	}


}