package com.gohyo.app.product;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	public List<ProductDTO> getList(Pager pager) {
		pager.makeRow();
		Long totalCount = productDAO.getTotal(pager);
		
		pager.makeNum(totalCount);
		List<ProductDTO> ar = this.productDAO.getlist(pager); 
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO pdto) throws Exception{
		return productDAO.getDetail(pdto);
	}
	
	public int add(ProductDTO pdto, MultipartFile file) throws Exception {
		// product값이 들어오고 그 안에 파일을 넣는
		int result = productDAO.add(pdto);
		// 1. 어디에 저장
		String path = servletContext.getRealPath("/resources/upload");
		System.out.println(path);
		
		File f = new File(path,"products");
		
		if(!f.exists()) {
			f.mkdir();
		}
		// 2. 파일명 (겹치지 않도록)
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		
		// 3. 파일저장
		f = new File(f, fileName);
		
		// FileCopyUtils 클래스 사용
		FileCopyUtils.copy(file.getBytes(), f);
		
		// 4. DB에 정보저장 (메서드 초반에 add 선언해놓았기에 가능함)
		ProductFileDTO pfdto = new ProductFileDTO();
		pfdto.setFileName(fileName);
		pfdto.setOriName(file.getOriginalFilename());
		pfdto.setProductNum(pdto.getProductNum());
		
		return productDAO.addFile(pfdto);
	}
	
	public int delete(ProductDTO pdto) throws Exception{
		return productDAO.delete(pdto);
	}
}

























