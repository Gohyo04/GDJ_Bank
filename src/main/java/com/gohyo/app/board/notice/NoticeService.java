package com.gohyo.app.board.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardFileDTO;
import com.gohyo.app.board.BoardService;
import com.gohyo.app.util.FileManager;
import com.gohyo.app.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	@Qualifier("noticeDAO")
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		
		// 검색
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		// 1. 글 등록 - 글번호를 알아오기 위해서
		int result = noticeDAO.setAdd(boardDTO);
		
		// 2. 파일을 HDD에 저장
		// 2-1. 저장할 폴더의 실제경로 구하기
		String path = servletContext.getRealPath("/resources/upload/notice");
		
		// 2-2. HDD에 저장하고 파일명 받아오기
		for (MultipartFile f : attachs) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);			
			// 3. DB에 파일 정보 저장하기
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setNoticeNum(boardDTO.getNoticeNum());
			result = noticeDAO.addFile(boardFileDTO);
		}
		
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		List<BoardFileDTO> ar = noticeDAO.getFileList(boardDTO);
		// 파일경로
		String path = servletContext.getRealPath("/resources/update/notice");
		// 경로,파일명으로 파일 삭제
		for(BoardFileDTO b : ar) {
			fileManager.fileDelete(path, b.getFileName());
		}
		noticeDAO.setFileDelete(boardDTO);
		
		int result = noticeDAO.setDelete(boardDTO);
		return result;
	}
	
	
}
