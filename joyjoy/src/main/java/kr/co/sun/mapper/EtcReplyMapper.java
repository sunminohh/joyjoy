package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.EtcReplyVO;
import kr.co.sun.domain.GameReplyVO;
import kr.co.sun.domain.MovieReplyVO;
import kr.co.sun.domain.Pagination;

@Mapper
public interface EtcReplyMapper {

	public int insert(EtcReplyVO vo);
	
	public EtcReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(EtcReplyVO reply);
	
	public List<EtcReplyVO> getListWithPaging(
			@Param("pagination") Pagination pagination,
			@Param("bno") Long bno);
	
	public int getCountByBno(Long bno);
	
}
