package com.gohyo.app.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	//파일삭제
	public boolean fileDelete(String path, String fileName)throws Exception{
		File file = new File(path, fileName);
		return file.delete();
	}
	
	//파일저장
	public String fileSave(String path, MultipartFile file)throws Exception{
		System.out.println(path);
		//path : realpath
		File f = new File(path);		
		
		
		if(f.isFile()) {
			throw new Exception();
		}
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		
		// 시간 사용
		Calendar ca = Calendar.getInstance();
		String fileName=ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println(fileName);
		
		
		f= new File(f, fileName);
		// 파일을 저장
		file.transferTo(f);
		
		return fileName;
	}
}
