package com.gohyo.app.account;

import java.sql.Date;
import java.util.List;

import com.gohyo.app.product.ProductDTO;

public class AccountDTO {
	private Long accountNum;
	private String userName;
	private Long productNum;
	private int accountPw;
	private Date accountDate;
	private Long accountBalance;
	
	private List<ProductDTO> productDTOs;
	
	
	
	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}
	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public int getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(int accountPw) {
		this.accountPw = accountPw;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
