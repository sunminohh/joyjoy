package kr.co.sun.mapper;

import java.util.List;

import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.BoardList;

public interface AdminMapper {
	
	public List<BoardList> getListWithPaging(Pagination pagination);
	public int getTotalCount(Pagination pagination);

}
