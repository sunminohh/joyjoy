package kr.co.sun.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class GameBoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String deleted;
	private Date regDate;
	private Date updateDate;
	
	private int readCnt;
	private int replyCnt;
	
	private List<GameAttachVO> attachList;
	
}
