package kr.co.sun.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.GameReplyVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.GameReplyDTO;
import kr.co.sun.mapper.GameBoardMapper;
import kr.co.sun.mapper.GameReplyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class GameReplyService {
	
	@Setter(onMethod = @__({@Autowired}))
	private GameReplyMapper mapper;
	
	@Setter(onMethod = @__({@Autowired}))
	private GameBoardMapper boardMapper;
	
	@Transactional
	public int register(GameReplyVO vo) {
		
		log.info("register......" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	public GameReplyVO get(Long rno) {
		
		log.info("get......" + rno);
		return mapper.read(rno);
	}

	public int modify(GameReplyVO vo) {
		
		log.info("modify......" + vo);
		return mapper.update(vo);
	}

	@Transactional
	public int remove(Long rno) {
		
		log.info("remove......" + rno);
		
		GameReplyVO vo = mapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	public List<GameReplyVO> getList(Pagination pagination, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(pagination, bno);
	}
	
	public GameReplyDTO getListPage(Pagination pagination, Long bno) {
		
		return new GameReplyDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(pagination, bno));
	}
	

	
}
