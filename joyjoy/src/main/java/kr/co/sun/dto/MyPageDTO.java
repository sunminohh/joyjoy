package kr.co.sun.dto;

import kr.co.sun.domain.MyPagination;
import kr.co.sun.domain.Pagination;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MyPageDTO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private MyPagination page;
	
	public MyPageDTO(MyPagination page, int total) {
		
		this.page = page;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(page.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / page.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}
	
}
