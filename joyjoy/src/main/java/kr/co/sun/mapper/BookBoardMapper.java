package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.BookBoardVO;
import kr.co.sun.domain.GameBoardVO;
import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.domain.Pagination;

public interface BookBoardMapper {

	public List<BookBoardVO> getListWithPaging(Pagination page);
	
	public void insert(BookBoardVO board);
	
	public void insertSelectKey(BookBoardVO board);
	
	public BookBoardVO read(Long bno);
	
	public int delete(BookBoardVO board);
	
	public int update(BookBoardVO board);
	
	public int getTotalCount(Pagination page);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	public int updateReadCnt(BookBoardVO board);
	
}
