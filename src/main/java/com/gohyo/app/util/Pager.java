package com.gohyo.app.util;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	private Long perPage=5L;//몇개씩 조회
	private Long page;
	
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	//이전 블럭이 없으면 true;
	private boolean start;
	//다음 블럭이 없으면 true;
	private boolean last;

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isStart() {
		return start;
	}


	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
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

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
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
	
	//startRow, lastRow계산하는 메서드
	public void makeRow() {
		this.lastRow=this.getPage()*this.getPerPage();
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage=0L;
		totalPage = totalCount/this.getPerPage();
		
		
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		this.setTotalPage(totalPage);
		
		//2. 총블럭의 수 구하기
		Long perBlock=5L;//블럭당 번호의 갯수
		Long totalBlock=0L;
		totalBlock=totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		//3. Page 값으로 현재 블럭 번호 구하기
		Long curBlock=0L;//블럭 번호
		curBlock=this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		//4. 현재 블럭 번호로 시작 번호와 끝번호 구하기
		Long startNum=0L;
		Long lastNum=curBlock*perBlock;
		startNum=lastNum-perBlock+1;
		
		this.setStartNum(startNum);
		this.setLastNum(lastNum);
		
		//이전, 다음 블럭 유무
		if(curBlock==1) {
			this.setStart(true);
		}
		
		if(curBlock==totalBlock) {
			this.setLastNum(totalPage);
			this.setLast(true);
		}
		
		if(totalCount <= 5) {
			this.page = 1L;
		}
	}
}