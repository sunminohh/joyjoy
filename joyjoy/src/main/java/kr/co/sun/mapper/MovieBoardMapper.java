package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.domain.Pagination;

public interface MovieBoardMapper {

	public List<MovieBoardVO> getListWithPaging(Pagination page);
	
	public void insert(MovieBoardVO board);
	
	public void insertSelectKey(MovieBoardVO board);
	
	public MovieBoardVO read(Long bno);
	
	public int delete(MovieBoardVO board);
	
	public int update(MovieBoardVO board);
	
	public int getTotalCount(Pagination page);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	public int updateReadCnt(MovieBoardVO board);
	
}
