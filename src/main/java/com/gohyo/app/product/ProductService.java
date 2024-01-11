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

import com.gohyo.app.util.FileManager;
import com.gohyo.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
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
	
	public int add(ProductDTO pdto, MultipartFile[] file) throws Exception {
		// product값이 들어오고 그 안에 파일을 넣는
		int result = productDAO.add(pdto);
		// 1. 어디에 저장할지
		String path = servletContext.getRealPath("/resources/upload/products");

		for(MultipartFile f : file) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
		
		//4. DB에 정보 저장
			ProductFileDTO dto = new ProductFileDTO();
			dto.setFileName(fileName);
			dto.setOriName(f.getOriginalFilename());
			dto.setProductNum(pdto.getProductNum());
			result = productDAO.addFile(dto);
		}
		return result;
	}
	
	
	public int delete(ProductDTO pdto) throws Exception{
		return productDAO.delete(pdto);
	}
}

























