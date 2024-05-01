package kr.co.sun.mapper;

import java.util.List;


import kr.co.sun.domain.GameAttachVO;

public interface GameAttachMapper {

	public void insert(GameAttachVO attach);
	
	public void delete(String uuid);
	
	public List<GameAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	public List<GameAttachVO> getOldFiles();
	
}
