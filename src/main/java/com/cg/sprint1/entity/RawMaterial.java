package com.cg.sprint1.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="raw_material")
public class RawMaterial {
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	@JsonFormat(pattern="dd-MM-yyyy",timezone="Asia/Calcutta")
	private Date processDate;
	@JsonFormat(pattern="dd-MM-yyyy",timezone="Asia/Calcutta")
	private Date mfDate;
	@JsonFormat(pattern="dd-MM-yyyy",timezone="Asia/Calcutta")
	private Date expDate;
	private String rmDeliveryStatus;
	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RawMaterial(int productId, String productName, double productPrice, int productQuantity, Date processDate,
			Date mfDate, Date expDate, String rmDeliveryStatus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.processDate = processDate;
		this.mfDate = mfDate;
		this.expDate = expDate;
		this.rmDeliveryStatus = rmDeliveryStatus;
	}
	@Override
	public String toString() {
		return "RawMaterial [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", processDate=" + processDate + ", mfDate=" + mfDate
				+ ", expDate=" + expDate + ", rmDeliveryStatus=" + rmDeliveryStatus + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public Date getMfDate() {
		return mfDate;
	}
	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getRmDeliveryStatus() {
		return rmDeliveryStatus;
	}
	public void setRmDeliveryStatus(String rmDeliveryStatus) {
		this.rmDeliveryStatus = rmDeliveryStatus;
	}
			
}
