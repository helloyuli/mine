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
 * 工艺数量折算系数表
 * @author sandong.xiao
 *  table="tyfact"
 */
 @Entity(name = "TyfactInfo")
@Table(name = "tyfact")
public class TyfactInfo implements Serializable {

	private static final long serialVersionUID = 1L;


	// constructors
	public TyfactInfo () {
		
	}

	/**
	 * Constructor for primary key
	 */
	public TyfactInfo (String tyfaid) {
		this.setTyfaid(tyfaid);
	}

	// primary key
	@Id
    @Column(name = "tyfaid", nullable = false, unique=true, columnDefinition="CHAR(36)")
	private String tyfaid;

	// fields
	@Column(name = "companycode", nullable = false, unique = false, columnDefinition = "CHAR(36)")
    private String companycode;
	@Column(name = "teuuid", nullable = false, unique = false, columnDefinition = "CHAR(36)")
    private String teuuid; // 工艺表id
	@Column(name = "crteno", nullable = true, unique = false, columnDefinition = "VARCHAR(32)")
    private String crteno; // 工艺号
	@Column(name = "crtenm", nullable = true, unique = false, columnDefinition = "VARCHAR(32)")
    private String crtenm; //工艺名称
	@Column(name = "sxtype", nullable = true, unique = false, columnDefinition = "VARCHAR(2)")
	private String sxtype; // 上、下衣属性
	@Column(name = "factor", nullable = true, unique = false, columnDefinition = "DECIMAL")
	private BigDecimal factor = BigDecimal.ONE; // 工艺数量折算系数(默认1)
	@Column(name = "txtyf1", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txtyf1;
	@Column(name = "txtyf2", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txtyf2;
	@Column(name = "txtyf3", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txtyf3;
	
	@Column(name = "remark", nullable = true, unique = false, columnDefinition = "VARCHAR(256)")
	private String remark;
	@Column(name = "OPRTBY", nullable = false, unique = false, columnDefinition = "VARCHAR(32)")
    private String oprtby = " ";
    @Column(name = "OPRTTM", nullable = false, unique = false, columnDefinition = "datetime")
    private java.util.Date oprttm;
	@Column(name = "CRETBY", nullable = false, unique = false, columnDefinition = "VARCHAR(32)")
    private String cretby = " ";
    @Column(name = "CRETTM", nullable = false, unique = false, columnDefinition = "datetime")
    private java.util.Date crettm;


	public String getTyfaid() {
		return tyfaid;
	}

	public String getCompanycode() {
		return companycode;
	}

	public String getTeuuid() {
		return teuuid;
	}

	public String getCrteno() {
		return crteno;
	}

	public String getCrtenm() {
		return crtenm;
	}

	public String getSxtype() {
		return sxtype;
	}

	public BigDecimal getFactor() {
		return factor;
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

	public void setTyfaid(String tyfaid) {
		this.tyfaid = tyfaid;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public void setTeuuid(String teuuid) {
		this.teuuid = teuuid;
	}

	public void setCrteno(String crteno) {
		this.crteno = crteno;
	}

	public void setCrtenm(String crtenm) {
		this.crtenm = crtenm;
	}

	public void setSxtype(String sxtype) {
		this.sxtype = sxtype;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String getTxtyf1() {
		return txtyf1;
	}

	public String getTxtyf2() {
		return txtyf2;
	}

	public String getTxtyf3() {
		return txtyf3;
	}

	public void setTxtyf1(String txtyf1) {
		this.txtyf1 = txtyf1;
	}

	public void setTxtyf2(String txtyf2) {
		this.txtyf2 = txtyf2;
	}

	public void setTxtyf3(String txtyf3) {
		this.txtyf3 = txtyf3;
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