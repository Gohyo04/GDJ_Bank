package com.gohyo.app.wish;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.account.AccountDTO;

@Repository
public class WishDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gohyo.app.wish.WishDAO.";
	
	public int addWish(AccountDTO accountDTO) {
		return sqlSession.insert(NAMESPACE+"addWish", accountDTO);
	}
}
