package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Pager pager) {
		pager.makeRow();
		List<ProductDTO> ar = this.productDAO.getlist(pager); 
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO pdto) {
		return productDAO.getDetail(pdto);
	}
}
