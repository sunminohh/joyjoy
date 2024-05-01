package kr.co.sun.mapper;

import java.util.List;


import kr.co.sun.domain.EtcAttachVO;
import kr.co.sun.domain.GameAttachVO;
import kr.co.sun.domain.MovieAttachVO;

public interface EtcAttachMapper {

	public void insert(EtcAttachVO attach);
	
	public void delete(String uuid);
	
	public List<EtcAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	public List<EtcAttachVO> getOldFiles();
	
}
