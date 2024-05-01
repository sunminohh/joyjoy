package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.GameBoardVO;
import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.domain.Pagination;

public interface GameBoardMapper {

	public List<GameBoardVO> getListWithPaging(Pagination page);
	
	public void insert(GameBoardVO board);
	
	public void insertSelectKey(GameBoardVO board);
	
	public GameBoardVO read(Long bno);
	
	public int delete(GameBoardVO board);
	
	public int update(GameBoardVO board);
	
	public int getTotalCount(Pagination page);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	public int updateReadCnt(GameBoardVO board);
	
}
