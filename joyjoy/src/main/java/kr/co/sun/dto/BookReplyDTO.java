package kr.co.sun.dto;

import java.util.List;

import kr.co.sun.domain.BookReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class BookReplyDTO {

	private int replyCnt;
	private List<BookReplyVO> list;
	
}
