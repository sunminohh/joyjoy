package kr.co.sun.dto;

import java.util.List;

import kr.co.sun.domain.EtcReplyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class EtcReplyDTO {

	private int replyCnt;
	private List<EtcReplyVO> list;
	
}
