package kr.co.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sun.domain.BookBoardVO;
import kr.co.sun.domain.EtcBoardVO;
import kr.co.sun.domain.GameBoardVO;
import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.mapper.HomeMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class HomeService {

	@Setter(onMethod = @__({@Autowired}))
	private HomeMapper mapper;
	
	public List<MovieBoardVO> getMovieList() {
		
		return mapper.getMovieList();
	}
	
	public List<GameBoardVO> getGameList() {
		
		return mapper.getGameList();
	}
	
	public List<BookBoardVO> getBookList() {
		
		return mapper.getBookList();
	}
	
	public List<EtcBoardVO> getEtcList() {
		
		return mapper.getEtcList();
	}
}
