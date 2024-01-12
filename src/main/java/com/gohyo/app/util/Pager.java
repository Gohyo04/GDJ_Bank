package com.gohyo.app.util;

public class Pager {
	
	private Long startRow;		// = 1
	private Long lastRow;		// = totalCount/perPage
	private Long perPage = 10L; 
	private Long page;
	
	private Long totalPage;		// 총페이지
	
	// 블럭의 첫, 끝번호
	private Long startNum;
	private Long lastNum;
	// 블럭의 첫, 끝번호 판별
	private boolean start;
	private boolean last;
	
	// 검색
	private String search;
	private String kind; 	// 검색 유형?
	
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
	
	
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void makeRow() {
		this.lastRow = this.getPage()*this.getPerPage();
		this.startRow = lastRow-this.perPage+1;
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage = totalCount/this.getPerPage();
		
		if(totalPage % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 블럭 관련
		Long perBlock = 5L;
		Long nblock = totalPage / perBlock;
		
		if(totalPage % perBlock != 0) {
			nblock++;
		}
		
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock != 0) {
			curBlock++;
		}
		
		// 첫, 끝페이지 번호
		this.setLastNum(curBlock * perBlock);
		this.setStartNum(this.lastNum - perBlock +1);
		
		if(curBlock == 1) {
			this.setStart(true);
		}
		
		if(curBlock == nblock) {
			this.setLastNum(totalPage);
			this.setLast(true);
		}
		
		if(totalCount <= 10) {
			this.setStartNum(1L);
			this.setLastNum(1L);
		}
	}
}



















