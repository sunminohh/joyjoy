package kr.co.sun.mapper;

import java.util.List;

import kr.co.sun.domain.BookBoardVO;
import kr.co.sun.domain.EtcBoardVO;
import kr.co.sun.domain.GameBoardVO;
import kr.co.sun.domain.MovieBoardVO;

public interface HomeMapper {

	public List<MovieBoardVO> getMovieList();
	
	public List<GameBoardVO> getGameList();
	
	public List<BookBoardVO> getBookList();
	
	public List<EtcBoardVO> getEtcList();
	
}
