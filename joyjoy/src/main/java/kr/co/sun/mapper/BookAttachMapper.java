package kr.co.sun.mapper;

import java.util.List;


import kr.co.sun.domain.BookAttachVO;
import kr.co.sun.domain.GameAttachVO;
import kr.co.sun.domain.MovieAttachVO;

public interface BookAttachMapper {

	public void insert(BookAttachVO attach);
	
	public void delete(String uuid);
	
	public List<BookAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	public List<BookAttachVO> getOldFiles();
	
}
