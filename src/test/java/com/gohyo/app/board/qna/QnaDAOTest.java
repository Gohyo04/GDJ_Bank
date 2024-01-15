package com.gohyo.app.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gohyo.app.MyTest;
import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.util.Pager;

public class QnaDAOTest extends MyTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = qnaDAO.getList(pager);
		
		assertEquals(2, ar.size());
	}
}
