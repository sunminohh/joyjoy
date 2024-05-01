package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.MovieReplyVO;
import kr.co.sun.domain.Pagination;

@Mapper
public interface MovieReplyMapper {

	public int insert(MovieReplyVO vo);
	
	public MovieReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(MovieReplyVO reply);
	
	public List<MovieReplyVO> getListWithPaging(
			@Param("pagination") Pagination pagination,
			@Param("bno") Long bno);
	
	public int getCountByBno(Long bno);
	
}
