package kr.co.sun.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import kr.co.sun.domain.EtcBoardVO;
import kr.co.sun.domain.GameBoardVO;
import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.domain.Pagination;

public interface EtcBoardMapper {

	public List<EtcBoardVO> getListWithPaging(Pagination page);
	
	public void insert(EtcBoardVO board);
	
	public void insertSelectKey(EtcBoardVO board);
	
	public EtcBoardVO read(Long bno);
	
	public int delete(EtcBoardVO board);
	
	public int update(EtcBoardVO board);
	
	public int getTotalCount(Pagination page);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	public int updateReadCnt(EtcBoardVO board);
	
}
