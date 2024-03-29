package com.gohyo.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.util.Pager;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO replyDAO;
	
	public Map<String,Object> setReply(ReplyDTO replyDTO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		replyDAO.setReply(replyDTO);
//		map.put("list", replyDAO.getList(replyDTO));
		return map;
	}
	
	public List<ReplyDTO> getList(Pager pager, ReplyDTO replyDTO)throws Exception{
		pager.setPerPage(5L);
		pager.makeRow();
		
		pager.makeNum(replyDAO.getTotalCount(replyDTO));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("replyDTO", replyDTO);
		return replyDAO.getList(map);
	}
	
	public int setUpdate(ReplyDTO replyDTO) throws Exception{
		return replyDAO.setUpdate(replyDTO);
	}
	
	public int setDelete(ReplyDTO replyDTO) throws Exception{
		return replyDAO.setDelete(replyDTO);
	}
}
