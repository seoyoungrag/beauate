package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BEUTY_USER database table.
 * 
 */
@Entity
@Table(name="BEUTY_USER")
@NamedQuery(name="BeutyUser.findAll", query="SELECT b FROM BeutyUser b")
public class BeutyUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private int userId;

	@Column(length=300)
	private String addr;

	@Column(name="DEL_YN", length=1)
	private String delYn;

	@Column(name="EMAIL_ADDR", length=100)
	private String emailAddr;

	@Column(name="FAX_NO", length=50)
	private String faxNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="JOIN_DT")
	private Date joinDt;

	@Column(name="MBL_PNO", length=50)
	private String mblPno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MOD_DT")
	private Date modDt;

	@Column(name="MOD_ID", length=20)
	private String modId;

	@Column(length=50)
	private String pno;

	@Column(name="USER_ENG_NM", length=100)
	private String userEngNm;

	@Column(name="USER_NM", nullable=false, length=100)
	private String userNm;

	@Column(name="USER_PW", nullable=false, length=100)
	private String userPw;

	@Column(name="ZIP_NO", length=5)
	private String zipNo;

	//bi-directional many-to-many association to AthrMng
	@ManyToMany
	@JoinTable(
		name="ATHR_USER_MAPNG"
		, joinColumns={
			@JoinColumn(name="USER_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ATHR_ID", nullable=false)
			}
		)
	private List<AthrMng> athrMngs;

	//bi-directional many-to-one association to CnntLog
	@OneToMany(mappedBy="beutyUser")
	private List<CnntLog> cnntLogs;

	public BeutyUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDelYn() {
		return this.delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getEmailAddr() {
		return this.emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public Date getJoinDt() {
		return this.joinDt;
	}

	public void setJoinDt(Date joinDt) {
		this.joinDt = joinDt;
	}

	public String getMblPno() {
		return this.mblPno;
	}

	public void setMblPno(String mblPno) {
		this.mblPno = mblPno;
	}

	public Date getModDt() {
		return this.modDt;
	}

	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}

	public String getModId() {
		return this.modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getPno() {
		return this.pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getUserEngNm() {
		return this.userEngNm;
	}

	public void setUserEngNm(String userEngNm) {
		this.userEngNm = userEngNm;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPw() {
		return this.userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getZipNo() {
		return this.zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public List<AthrMng> getAthrMngs() {
		return this.athrMngs;
	}

	public void setAthrMngs(List<AthrMng> athrMngs) {
		this.athrMngs = athrMngs;
	}

	public List<CnntLog> getCnntLogs() {
		return this.cnntLogs;
	}

	public void setCnntLogs(List<CnntLog> cnntLogs) {
		this.cnntLogs = cnntLogs;
	}

	public CnntLog addCnntLog(CnntLog cnntLog) {
		getCnntLogs().add(cnntLog);
		cnntLog.setBeutyUser(this);

		return cnntLog;
	}

	public CnntLog removeCnntLog(CnntLog cnntLog) {
		getCnntLogs().remove(cnntLog);
		cnntLog.setBeutyUser(null);

		return cnntLog;
	}

}