package kr.co.sun.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.MovieReplyVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.MovieReplyDTO;
import kr.co.sun.mapper.MovieBoardMapper;
import kr.co.sun.mapper.MovieReplyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MovieReplyService {
	
	@Setter(onMethod = @__({@Autowired}))
	private MovieReplyMapper mapper;
	
	@Setter(onMethod = @__({@Autowired}))
	private MovieBoardMapper boardMapper;
	
	@Transactional
	public int register(MovieReplyVO vo) {
		
		log.info("register......" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	public MovieReplyVO get(Long rno) {
		
		log.info("get......" + rno);
		return mapper.read(rno);
	}

	public int modify(MovieReplyVO vo) {
		
		log.info("modify......" + vo);
		return mapper.update(vo);
	}

	@Transactional
	public int remove(Long rno) {
		
		log.info("remove......" + rno);
		
		MovieReplyVO vo = mapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	public List<MovieReplyVO> getList(Pagination pagination, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(pagination, bno);
	}
	
	public MovieReplyDTO getListPage(Pagination pagination, Long bno) {
		
		return new MovieReplyDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(pagination, bno));
	}
	

	
}
