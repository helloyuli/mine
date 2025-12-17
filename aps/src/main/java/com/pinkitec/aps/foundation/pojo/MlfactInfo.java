/**
 *@copyright :Copyright @2018, Pinkitec ltd. All right reserved.
 */
package com.pinkitec.aps.foundation.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 面料折算系数表
 * @author sandong.xiao
 *  table="mlfact"
 */
 @Entity(name = "MlfactInfo")
@Table(name = "mlfact")
public class MlfactInfo implements Serializable {

	private static final long serialVersionUID = 1L;


	// constructors
	public MlfactInfo () {
		
	}

	/**
	 * Constructor for primary key
	 */
	public MlfactInfo (String mluuid) {
		this.setMluuid(mluuid);
	}


	// primary key
	@Id
    @Column(name = "MLUUID", nullable = false, unique=true, columnDefinition="CHAR(36)")
	private String mluuid;

	// fields
	@Column(name = "companycode", nullable = false, unique = false, columnDefinition = "CHAR(36)")
    private String companycode;
	@Column(name = "mtlmid", nullable = false, unique = false, columnDefinition = "CHAR(36)")
    private String mtlmid; // 物料表id
	@Column(name = "skuno", nullable = true, unique = false, columnDefinition = "VARCHAR(32)")
    private String skuno; // 物料号
	@Column(name = "skunam", nullable = true, unique = false, columnDefinition = "VARCHAR(32)")
    private String skunam; // 物料名称
	@Column(name = "sxtype", nullable = true, unique = false, columnDefinition = "VARCHAR(2)")
	private String sxtype; // 上、下衣属性
	@Column(name = "factor", nullable = true, unique = false, columnDefinition = "DECIMAL")
	private BigDecimal factor = BigDecimal.ONE; // 面料折算系数(默认1)
	@Column(name = "txmlf1", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txmlf1;
	@Column(name = "txmlf2", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txmlf2;
	@Column(name = "txmlf3", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txmlf3;
	@Column(name = "remark", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String remark;

	
	
	@Column(name = "OPRTBY", nullable = false, unique = false, columnDefinition = "VARCHAR(32)")
    private String oprtby = " ";
    @Column(name = "OPRTTM", nullable = false, unique = false, columnDefinition = "datetime")
    private java.util.Date oprttm;
	@Column(name = "CRETBY", nullable = false, unique = false, columnDefinition = "VARCHAR(32)")
    private String cretby = " ";
    @Column(name = "CRETTM", nullable = false, unique = false, columnDefinition = "datetime")
    private java.util.Date crettm;


	public String getMluuid() {
		return mluuid;
	}

	public String getCompanycode() {
		return companycode;
	}

	public String getMtlmid() {
		return mtlmid;
	}

	public String getSkuno() {
		return skuno;
	}

	public String getSkunam() {
		return skunam;
	}

	public String getSxtype() {
		return sxtype;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public String getTxmlf1() {
		return txmlf1;
	}

	public String getTxmlf2() {
		return txmlf2;
	}

	public String getTxmlf3() {
		return txmlf3;
	}

	public String getRemark() {
		return remark;
	}

	public String getOprtby() {
		return oprtby;
	}

	public java.util.Date getOprttm() {
		return oprttm;
	}

	public String getCretby() {
		return cretby;
	}

	public java.util.Date getCrettm() {
		return crettm;
	}

	public void setMluuid(String mluuid) {
		this.mluuid = mluuid;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public void setMtlmid(String mtlmid) {
		this.mtlmid = mtlmid;
	}

	public void setSkuno(String skuno) {
		this.skuno = skuno;
	}

	public void setSkunam(String skunam) {
		this.skunam = skunam;
	}

	public void setSxtype(String sxtype) {
		this.sxtype = sxtype;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public void setTxmlf1(String txmlf1) {
		this.txmlf1 = txmlf1;
	}

	public void setTxmlf2(String txmlf2) {
		this.txmlf2 = txmlf2;
	}

	public void setTxmlf3(String txmlf3) {
		this.txmlf3 = txmlf3;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setOprtby(String oprtby) {
		this.oprtby = oprtby;
	}

	public void setOprttm(java.util.Date oprttm) {
		this.oprttm = oprttm;
	}

	public void setCretby(String cretby) {
		this.cretby = cretby;
	}

	public void setCrettm(java.util.Date crettm) {
		this.crettm = crettm;
	}



    
}