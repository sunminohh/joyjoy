package kr.co.sun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.BoardList;
import kr.co.sun.mapper.AdminMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminService {
	
	private final AdminMapper mapper;
	
    public AdminService(AdminMapper mapper) {
        this.mapper = mapper;
    }
	
	public List<BoardList> getList(Pagination page) {
		
		log.info("get List with pagination: " + page);
		return mapper.getListWithPaging(page);
	}
	
	public int getTotal(Pagination page) {
		
		log.info("get total count");
		return mapper.getTotalCount(page);
	}

}
