package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CNNT_LOG database table.
 * 
 */
@Embeddable
public class CnntLogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CNNT_LOG_ID", unique=true, nullable=false)
	private int cnntLogId;

	@Column(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int userId;

	public CnntLogPK() {
	}
	public int getCnntLogId() {
		return this.cnntLogId;
	}
	public void setCnntLogId(int cnntLogId) {
		this.cnntLogId = cnntLogId;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CnntLogPK)) {
			return false;
		}
		CnntLogPK castOther = (CnntLogPK)other;
		return 
			(this.cnntLogId == castOther.cnntLogId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cnntLogId;
		hash = hash * prime + this.userId;
		
		return hash;
	}
}