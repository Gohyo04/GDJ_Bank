package com.gohyo.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gohyo.app.member.MemberDAO.";
	
	public int addUser(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE+"addUser", memberDTO);  
	}
	
	public int addFile(AvatarDTO avatarDTO) {
		return sqlSession.insert(NAMESPACE+"addFile", avatarDTO);
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
	}
}
