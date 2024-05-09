package kr.co.sun.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardList {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String deleted;
	private Date regDate;
	private Date updateDate;
	private int readCnt;
	private int replyCnt;
	private String type;
	
	@Builder
	public BoardList(Long bno, String title, String content, String writer, String deleted, Date regDate,
			Date updateDate, int readCnt, int replyCnt, String type) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.deleted = deleted;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.readCnt = readCnt;
		this.replyCnt = replyCnt;
		this.type = type;
	}
	
	
}
