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
 * 工段路线参数表
 * @author sandong.xiao
 *  table="consjt"
 */
 @Entity(name = "ConsjtInfo")
@Table(name = "consjt")
public class ConsjtInfo implements Serializable {

	private static final long serialVersionUID = 1L;


	// constructors
	public ConsjtInfo () {
		
	}

	/**
	 * Constructor for primary key
	 */
	public ConsjtInfo (String consid) {
		this.setConsid(consid);
	}

	// primary key
	@Id
    @Column(name = "consid", nullable = false, unique=true, columnDefinition="CHAR(36)")
	private String consid;

	// fields
	@Column(name = "companycode", nullable = false, unique = false, columnDefinition = "CHAR(36)")
    private String companycode;
	@Column(name = "ortype", nullable = true, unique = false, columnDefinition = "VARCHAR(3)")
    private String ortype; // 车间订单类别属性(大货、样衣、高定)
	@Column(name = "contyp", nullable = true, unique = false, columnDefinition = "VARCHAR(2)")
    private String contyp; //工段类型(Cut裁剪、sewwing缝制、ironing整烫、pack包装、bale打包)
	@Column(name = "period", nullable = true, unique = false, columnDefinition = "DECIMAL")
	private BigDecimal period = BigDecimal.ZERO; // 周期（天）(默认0)
	@Column(name = "txcon1", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txcon1;
	@Column(name = "txcon2", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txcon2;
	@Column(name = "txcon3", nullable = true, unique = false, columnDefinition = "VARCHAR(64)")
	private String txcon3;
	
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


	public String getConsid() {
		return consid;
	}

	public String getCompanycode() {
		return companycode;
	}

	public String getOrtype() {
		return ortype;
	}

	public String getContyp() {
		return contyp;
	}

	public BigDecimal getPeriod() {
		return period;
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

	public void setConsid(String consid) {
		this.consid = consid;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public void setOrtype(String ortype) {
		this.ortype = ortype;
	}

	public void setContyp(String contyp) {
		this.contyp = contyp;
	}

	public void setPeriod(BigDecimal period) {
		this.period = period;
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

	public String getTxcon1() {
		return txcon1;
	}

	public String getTxcon2() {
		return txcon2;
	}

	public String getTxcon3() {
		return txcon3;
	}

	public void setTxcon1(String txcon1) {
		this.txcon1 = txcon1;
	}

	public void setTxcon2(String txcon2) {
		this.txcon2 = txcon2;
	}

	public void setTxcon3(String txcon3) {
		this.txcon3 = txcon3;
	}
}