package kr.co.sun.mapper;

import java.util.List;

import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.BoardList;
import kr.co.sun.dto.ReplyList;

public interface AdminMapper {
	
	public List<BoardList> getBoardList(Pagination pagination);
	public int getTotalCount(Pagination pagination);

	public List<ReplyList> getReplyList(Pagination pagination);
	public int getRTotalCount(Pagination pagination);
}
