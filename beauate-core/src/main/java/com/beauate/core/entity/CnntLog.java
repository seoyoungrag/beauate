package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CNNT_LOG database table.
 * 
 */
@Entity
@Table(name="CNNT_LOG")
@NamedQuery(name="CnntLog.findAll", query="SELECT c FROM CnntLog c")
public class CnntLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CnntLogPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CNNT_DT")
	private Date cnntDt;

	@Column(name="CNNT_IP", length=50)
	private String cnntIp;

	@Column(name="CNNT_LOG_ID", nullable=false, insertable=false, updatable=false)
	private int cnntLogId;

	//bi-directional many-to-one association to BeutyUser
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private BeutyUser beutyUser;

	public CnntLog() {
	}

	public CnntLogPK getId() {
		return this.id;
	}

	public void setId(CnntLogPK id) {
		this.id = id;
	}

	public Date getCnntDt() {
		return this.cnntDt;
	}

	public void setCnntDt(Date cnntDt) {
		this.cnntDt = cnntDt;
	}

	public String getCnntIp() {
		return this.cnntIp;
	}

	public void setCnntIp(String cnntIp) {
		this.cnntIp = cnntIp;
	}

	public int getCnntLogId() {
		return this.cnntLogId;
	}

	public void setCnntLogId(int cnntLogId) {
		this.cnntLogId = cnntLogId;
	}

	public BeutyUser getBeutyUser() {
		return this.beutyUser;
	}

	public void setBeutyUser(BeutyUser beutyUser) {
		this.beutyUser = beutyUser;
	}

}