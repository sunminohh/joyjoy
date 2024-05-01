package kr.co.sun.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.EtcReplyVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.EtcReplyDTO;
import kr.co.sun.mapper.EtcBoardMapper;
import kr.co.sun.mapper.EtcReplyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class EtcReplyService {
	
	@Setter(onMethod = @__({@Autowired}))
	private EtcReplyMapper mapper;
	
	@Setter(onMethod = @__({@Autowired}))
	private EtcBoardMapper boardMapper;
	
	@Transactional
	public int register(EtcReplyVO vo) {
		
		log.info("register......" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	public EtcReplyVO get(Long rno) {
		
		log.info("get......" + rno);
		return mapper.read(rno);
	}

	public int modify(EtcReplyVO vo) {
		
		log.info("modify......" + vo);
		return mapper.update(vo);
	}

	@Transactional
	public int remove(Long rno) {
		
		log.info("remove......" + rno);
		
		EtcReplyVO vo = mapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	public List<EtcReplyVO> getList(Pagination pagination, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(pagination, bno);
	}
	
	public EtcReplyDTO getListPage(Pagination pagination, Long bno) {
		
		return new EtcReplyDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(pagination, bno));
	}
	

	
}
