package kr.co.sun.mapper;

import java.util.List;


import kr.co.sun.domain.MovieAttachVO;

public interface MovieAttachMapper {

	public void insert(MovieAttachVO attach);
	
	public void delete(String uuid);
	
	public List<MovieAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	public List<MovieAttachVO> getOldFiles();
	
}
