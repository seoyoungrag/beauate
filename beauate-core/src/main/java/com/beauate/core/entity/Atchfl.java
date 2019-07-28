package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ATCHFL database table.
 * 
 */
@Entity
@Table(name="ATCHFL")
@NamedQuery(name="Atchfl.findAll", query="SELECT a FROM Atchfl a")
public class Atchfl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ATCHFL_ID", unique=true, nullable=false)
	private int atchflId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRET_DE")
	private Date cretDe;

	@Column(name="USE_YN", length=1)
	private String useYn;

	//bi-directional many-to-one association to AtchflDtl
	@OneToMany(mappedBy="atchfl")
	private List<AtchflDtl> atchflDtls;

	public Atchfl() {
	}

	public int getAtchflId() {
		return this.atchflId;
	}

	public void setAtchflId(int atchflId) {
		this.atchflId = atchflId;
	}

	public Date getCretDe() {
		return this.cretDe;
	}

	public void setCretDe(Date cretDe) {
		this.cretDe = cretDe;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public List<AtchflDtl> getAtchflDtls() {
		return this.atchflDtls;
	}

	public void setAtchflDtls(List<AtchflDtl> atchflDtls) {
		this.atchflDtls = atchflDtls;
	}

	public AtchflDtl addAtchflDtl(AtchflDtl atchflDtl) {
		getAtchflDtls().add(atchflDtl);
		atchflDtl.setAtchfl(this);

		return atchflDtl;
	}

	public AtchflDtl removeAtchflDtl(AtchflDtl atchflDtl) {
		getAtchflDtls().remove(atchflDtl);
		atchflDtl.setAtchfl(null);

		return atchflDtl;
	}

}