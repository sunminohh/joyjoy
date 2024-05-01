package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.BookReplyVO;
import kr.co.sun.domain.Pagination;

@Mapper
public interface BookReplyMapper {

	public int insert(BookReplyVO vo);
	
	public BookReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(BookReplyVO reply);
	
	public List<BookReplyVO> getListWithPaging(
			@Param("pagination") Pagination pagination,
			@Param("bno") Long bno);
	
	public int getCountByBno(Long bno);
	
}
