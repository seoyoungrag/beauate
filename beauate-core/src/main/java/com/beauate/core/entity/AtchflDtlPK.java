package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ATCHFL_DTL database table.
 * 
 */
@Embeddable
public class AtchflDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ATCHFL_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int atchflId;

	@Column(name="FILE_SN", unique=true, nullable=false)
	private int fileSn;

	public AtchflDtlPK() {
	}
	public int getAtchflId() {
		return this.atchflId;
	}
	public void setAtchflId(int atchflId) {
		this.atchflId = atchflId;
	}
	public int getFileSn() {
		return this.fileSn;
	}
	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtchflDtlPK)) {
			return false;
		}
		AtchflDtlPK castOther = (AtchflDtlPK)other;
		return 
			(this.atchflId == castOther.atchflId)
			&& (this.fileSn == castOther.fileSn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.atchflId;
		hash = hash * prime + this.fileSn;
		
		return hash;
	}
}