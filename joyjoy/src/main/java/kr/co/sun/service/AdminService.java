package kr.co.sun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.BoardList;
import kr.co.sun.dto.ReplyList;
import kr.co.sun.mapper.AdminMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminService {
	
	private final AdminMapper mapper;
	
    public AdminService(AdminMapper mapper) {
        this.mapper = mapper;
    }
	
	public List<BoardList> getBoardList(Pagination page) {
		log.info("getBoardList with pagination: " + page);
		return mapper.getBoardList(page);
	}
	
	public int getTotal(Pagination page) {
		return mapper.getTotalCount(page);
	}
	
	public List<ReplyList> getReplyList(Pagination page) {
		log.info("getReplyList with pagination: " + page);
		return mapper.getReplyList(page);
	}
	
	public int getRTotal (Pagination page) {
		return mapper.getRTotalCount(page);
	}

}
