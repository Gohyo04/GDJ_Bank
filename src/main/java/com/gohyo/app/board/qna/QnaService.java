package com.gohyo.app.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gohyo.app.board.BoardDTO;
import com.gohyo.app.board.BoardFileDTO;
import com.gohyo.app.board.BoardService;
import com.gohyo.app.util.FileManager;
import com.gohyo.app.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		boardDTO = qnaDAO.getDetail(boardDTO);
		return boardDTO;
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] file) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		
		String path = servletContext.getRealPath("/resources/upload/qnas");
		
		for(MultipartFile f : file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);

			// DB에 정보 저장
			BoardFileDTO dto = new BoardFileDTO();
			dto.setFileName(fileName);
			dto.setOriName(f.getOriginalFilename());
			dto.setNoticeNum(boardDTO.getNoticeNum());
			result = qnaDAO.addFile(dto);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
