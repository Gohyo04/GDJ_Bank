package com.gohyo.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gohyo.app.product.ReplyDAO.";
	
	public int setReply(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply",replyDTO);
	}
	
	public List<ReplyDTO> getList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getReplyList", map);
	}
	
	public Long getTotalCount(ReplyDTO replyDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount",replyDTO);
	}
	
	public int setUpdate(ReplyDTO replyDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate",replyDTO);
	}
	
	public int setDelete(ReplyDTO replyDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", replyDTO);
	}
}
