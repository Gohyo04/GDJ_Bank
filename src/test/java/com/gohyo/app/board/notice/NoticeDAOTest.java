package com.gohyo.app.board.notice;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gohyo.app.MyTest;
import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.util.Pager;


public class NoticeDAOTest extends MyTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		assertNotEquals(0, ar.size());
	}
}
