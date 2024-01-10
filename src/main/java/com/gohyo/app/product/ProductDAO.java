package com.gohyo.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gohyo.app.util.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.gohyo.app.product.ProductDAO.";
	
	public List<ProductDTO> getlist(Pager pager) {
		return sqlSession.selectList(namespace+"getList", pager);
	}
	
	public Long getTotal(Pager pager) {
		return sqlSession.selectOne(namespace+"getTotal",pager);
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) {
		return sqlSession.selectOne(namespace+"getDetail",productDTO);
	}
		
	public int add(ProductDTO productDTO) {
		return sqlSession.insert(namespace+"add",productDTO);
	}
	
	public int addFile(ProductFileDTO productFileDTO)throws Exception {
		return sqlSession.insert(namespace+"addFile", productFileDTO);
	}
	
	public int doUpdate(ProductDTO productDTO) {
		
		return 0;
	}
	
	public int delete(ProductDTO productDTO) {
		return sqlSession.delete(namespace+"delete", productDTO);
	}

	
}
