package com.gohyo.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.util.Pager;

@Repository
public class ProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.gohyo.app.product.ProductDAO.";
	
	public ProductDTO getDetail(ProductDTO productDTO) {
		return sqlSession.selectOne(namespace+"getDetail", productDTO);
	}
	
	public Long getTotal(Pager pager) {
		return sqlSession.selectOne(namespace+"getTotal",pager);
	}
	
	public List<ProductDTO> getList(Pager pager) {
		return sqlSession.selectList(namespace+"getList",pager);
	}
	
	public int add(ProductDTO productDTO) {
		return sqlSession.insert(namespace+"doAdd", productDTO);
	}
	
	public int update(ProductDTO productDTO) {
		return sqlSession.update(namespace+"doUpdate", productDTO);
	}
	
	public int delete(ProductDTO productDTO) {
		return sqlSession.delete(namespace+"delete", productDTO);
	}
}
