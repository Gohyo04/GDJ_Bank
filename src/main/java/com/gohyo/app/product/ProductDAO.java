package com.gohyo.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.gohyo.app.product.ProductDAO.";
	
	public List<ProductDTO> getList() {
		return sqlSession.selectList(namespace+"getList");
	}
	
	public int add(ProductDTO productDTO) {
		return sqlSession.insert(namespace+"doAdd", productDTO);
	}
}