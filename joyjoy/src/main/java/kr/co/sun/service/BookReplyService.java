package kr.co.sun.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.BookReplyVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.BookReplyDTO;
import kr.co.sun.mapper.BookBoardMapper;
import kr.co.sun.mapper.BookReplyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BookReplyService {
	
	@Setter(onMethod = @__({@Autowired}))
	private BookReplyMapper mapper;
	
	@Setter(onMethod = @__({@Autowired}))
	private BookBoardMapper boardMapper;
	
	@Transactional
	public int register(BookReplyVO vo) {
		
		log.info("register......" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	public BookReplyVO get(Long rno) {
		
		log.info("get......" + rno);
		return mapper.read(rno);
	}

	public int modify(BookReplyVO vo) {
		
		log.info("modify......" + vo);
		return mapper.update(vo);
	}

	@Transactional
	public int remove(Long rno) {
		
		log.info("remove......" + rno);
		
		BookReplyVO vo = mapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	public List<BookReplyVO> getList(Pagination pagination, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(pagination, bno);
	}
	
	public BookReplyDTO getListPage(Pagination pagination, Long bno) {
		
		return new BookReplyDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(pagination, bno));
	}
	

	
}
