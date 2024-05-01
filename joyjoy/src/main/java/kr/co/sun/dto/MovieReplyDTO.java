package kr.co.sun.dto;

import java.util.List;

import kr.co.sun.domain.MovieReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class MovieReplyDTO {

	private int replyCnt;
	private List<MovieReplyVO> list;
	
}
