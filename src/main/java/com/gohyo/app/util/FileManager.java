package com.gohyo.app.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String fileSave(String path, MultipartFile file)throws Exception{
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception();
		}
		
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
		
		return fileName;
	}
}
