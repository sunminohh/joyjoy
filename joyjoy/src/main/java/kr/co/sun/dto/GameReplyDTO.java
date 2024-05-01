package kr.co.sun.dto;

import java.util.List;

import kr.co.sun.domain.GameReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class GameReplyDTO {

	private int replyCnt;
	private List<GameReplyVO> list;
	
}
