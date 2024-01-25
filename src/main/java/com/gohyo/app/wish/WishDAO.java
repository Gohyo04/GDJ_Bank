package com.gohyo.app.wish;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.account.AccountDTO;
import com.gohyo.app.member.MemberDTO;
import com.gohyo.app.product.ProductDTO;

@Repository
public class WishDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gohyo.app.wish.WishDAO.";
	
	public int addWish(AccountDTO accountDTO) {
		return sqlSession.insert(NAMESPACE+"addWish", accountDTO);
	}
	
	public List<ProductDTO> getWishlist(MemberDTO memberDTO) {
		return sqlSession.selectList(NAMESPACE+"getWishlist",memberDTO);
	}
	
	public int deleteWish(Map<String, Object> map) {
		return sqlSession.delete(NAMESPACE+"deleteWish", map);
	}
}
