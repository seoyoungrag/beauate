package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MENU_STATS database table.
 * 
 */
@Entity
@Table(name="MENU_STATS")
@NamedQuery(name="MenuStat.findAll", query="SELECT m FROM MenuStat m")
public class MenuStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MenuStatPK id;

	@Column(name="CNNT_IP", length=50)
	private String cnntIp;

	@Column(name="CNNT_URL", length=50)
	private String cnntUrl;

	@Column(name="STATS_ID", nullable=false, insertable=false, updatable=false)
	private int statsId;

	@Column(name="USER_ID", length=35)
	private String userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="VIST_DE")
	private Date vistDe;

	//bi-directional many-to-one association to MenuMng
	@ManyToOne
	@JoinColumn(name="MENU_ID", nullable=false, insertable=false, updatable=false)
	private MenuMng menuMng;

	public MenuStat() {
	}

	public MenuStatPK getId() {
		return this.id;
	}

	public void setId(MenuStatPK id) {
		this.id = id;
	}

	public String getCnntIp() {
		return this.cnntIp;
	}

	public void setCnntIp(String cnntIp) {
		this.cnntIp = cnntIp;
	}

	public String getCnntUrl() {
		return this.cnntUrl;
	}

	public void setCnntUrl(String cnntUrl) {
		this.cnntUrl = cnntUrl;
	}

	public int getStatsId() {
		return this.statsId;
	}

	public void setStatsId(int statsId) {
		this.statsId = statsId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getVistDe() {
		return this.vistDe;
	}

	public void setVistDe(Date vistDe) {
		this.vistDe = vistDe;
	}

	public MenuMng getMenuMng() {
		return this.menuMng;
	}

	public void setMenuMng(MenuMng menuMng) {
		this.menuMng = menuMng;
	}

}