package com.gohyo.app.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	
	private final String NAMESPACE = "com.gohyo.app.account.AccountDAO.";
	
	public int accountAdd(AccountDTO accountDTO) {
		return sqlSession.insert(NAMESPACE+"accountAdd", accountDTO);
	}
	
	public List<AccountDTO> myAccount(Map<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+"myAccount", map);
	}
}
