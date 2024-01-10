package com.gohyo.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gohyo.app.product.ProductDAO;
import com.gohyo.app.product.ProductDTO;

public class ProductDAOTest extends MyTest{

	@Autowired
	private ProductDAO productDAO;
	
//	@Test
//	public void addTest() throws Exception{
//		ProductDTO pdto = new ProductDTO();
//		
//		for(int i=0;i<30;i++) {
//			pdto.setProductName("case"+i);
//			pdto.setProductContents("111"+i);
//			pdto.setProductJumsu(1.1);
//			pdto.setProductRate(2.2);
//			int result = productDAO.add(pdto);
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//		}
////		assertEquals(1, result);
//	}


}
