package com.beauate.core.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ATCHFL_DTL database table.
 * 
 */
@Entity
@Table(name="ATCHFL_DTL")
@NamedQuery(name="AtchflDtl.findAll", query="SELECT a FROM AtchflDtl a")
public class AtchflDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtchflDtlPK id;

	@Column(name="FILE_CN", length=4000)
	private String fileCn;

	@Column(name="FILE_EXTSN", length=20)
	private String fileExtsn;

	@Column(name="FILE_MG")
	private int fileMg;

	@Column(name="FILE_SN", nullable=false, insertable=false, updatable=false)
	private int fileSn;

	@Column(name="FILE_STRE_COURS", length=2000)
	private String fileStreCours;

	@Column(name="ORIGNL_FILE_NM", length=20)
	private String orignlFileNm;

	@Column(name="STRE_FILE_NM", length=20)
	private String streFileNm;

	//bi-directional many-to-one association to Atchfl
	@ManyToOne
	@JoinColumn(name="ATCHFL_ID", nullable=false, insertable=false, updatable=false)
	private Atchfl atchfl;

	public AtchflDtl() {
	}

	public AtchflDtlPK getId() {
		return this.id;
	}

	public void setId(AtchflDtlPK id) {
		this.id = id;
	}

	public String getFileCn() {
		return this.fileCn;
	}

	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}

	public String getFileExtsn() {
		return this.fileExtsn;
	}

	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}

	public int getFileMg() {
		return this.fileMg;
	}

	public void setFileMg(int fileMg) {
		this.fileMg = fileMg;
	}

	public int getFileSn() {
		return this.fileSn;
	}

	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileStreCours() {
		return this.fileStreCours;
	}

	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

	public String getOrignlFileNm() {
		return this.orignlFileNm;
	}

	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}

	public String getStreFileNm() {
		return this.streFileNm;
	}

	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}

	public Atchfl getAtchfl() {
		return this.atchfl;
	}

	public void setAtchfl(Atchfl atchfl) {
		this.atchfl = atchfl;
	}

}