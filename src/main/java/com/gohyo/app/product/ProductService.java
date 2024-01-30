package com.gohyo.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohyo.app.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	//detail
	public ProductDTO getDetail(ProductDTO productDTO, ReplyDTO replyDTO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("replylist", replyDAO.getList(pager,replyDTO));
		return productDTO = productDAO.getDetail(productDTO); 
	}
	
	//list
	public List<ProductDTO> getList(Pager pager)throws Exception{
		pager.makeRow();
		Long totalCount=productDAO.getTotal(pager);

		pager.makeNum(totalCount);
		
		List<ProductDTO> ar = this.productDAO.getList(pager);
		
		return ar;
	}
	
	// add
	public int add(ProductDTO productDTO) throws Exception{
		return productDAO.add(productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception{
		return productDAO.update(productDTO);
	}
	
	//delete
	public int delete(ProductDTO productDTO) throws Exception{
		return productDAO.delete(productDTO);
	}
}
