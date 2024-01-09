package com.gohyo.app.util;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long page;
	
	public void makeRow() {
		this.lastRow = this.getPage()*this.getPerPage();
		this.startRow = lastRow-this.perPage+1;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page==null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	
	
}
