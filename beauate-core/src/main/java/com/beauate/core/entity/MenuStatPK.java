package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MENU_STATS database table.
 * 
 */
@Embeddable
public class MenuStatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="STATS_ID", unique=true, nullable=false)
	private int statsId;

	@Column(name="MENU_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int menuId;

	public MenuStatPK() {
	}
	public int getStatsId() {
		return this.statsId;
	}
	public void setStatsId(int statsId) {
		this.statsId = statsId;
	}
	public int getMenuId() {
		return this.menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MenuStatPK)) {
			return false;
		}
		MenuStatPK castOther = (MenuStatPK)other;
		return 
			(this.statsId == castOther.statsId)
			&& (this.menuId == castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.statsId;
		hash = hash * prime + this.menuId;
		
		return hash;
	}
}