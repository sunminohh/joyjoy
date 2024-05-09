package kr.co.sun.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.MovieAttachVO;
import kr.co.sun.domain.MovieBoardVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.mapper.MovieAttachMapper;
import kr.co.sun.mapper.MovieBoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MovieBoardService {
	
	@Setter(onMethod = @__({@Autowired}))
	private MovieBoardMapper mapper;
	
	@Setter(onMethod = @__({@Autowired}))
	private MovieAttachMapper attachMapper;

	@Transactional
	public void register(MovieBoardVO board) {
		
		log.info("register..............." + board);
		
		mapper.insertSelectKey(board); 
		
		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	public MovieBoardVO get(Long bno) {
		
		log.info("get....." + bno);
		return mapper.read(bno);
	}
	
	public boolean updateRead(Long bno) {
		
		log.info("update readCnt" + bno);
		MovieBoardVO board = mapper.read(bno);
		board.setReadCnt(board.getReadCnt()+1);
		
		return mapper.updateReadCnt(board) == 1;
	}
	

	@Transactional
	public boolean modify(MovieBoardVO board) {
		
		log.info("modify....." + board);
		
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult = mapper.update(board) == 1;
		
		if (modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach -> {
				
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		
		return modifyResult;
	}

	@Transactional
	public boolean remove(Long bno) {
		
		log.info("remove....." + bno);
		
		attachMapper.deleteAll(bno);
		
		MovieBoardVO board = mapper.read(bno);
		board.setDeleted("Y"); 
		
		return mapper.delete(board) == 1;
	}
	
	public List<MovieBoardVO> getList(Pagination page) {
		
		log.info("get List with pagination: " + page);
		return mapper.getListWithPaging(page);
	}

	public int getTotal(Pagination page) {
		
		log.info("get total count");
		return mapper.getTotalCount(page);
	}

	public List<MovieAttachVO> getAttachList(Long bno) {
		
		log.info("get Attach list by bno" + bno);
		
		return attachMapper.findByBno(bno);
	}
	
}
