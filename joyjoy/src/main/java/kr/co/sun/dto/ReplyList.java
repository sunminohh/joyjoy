package kr.co.sun.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyList {
	
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	private String type;
	
	@Builder
	public ReplyList(Long rno, Long bno, String reply, String replyer, Date replyDate, Date updateDate, String type) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.reply = reply;
		this.replyer = replyer;
		this.replyDate = replyDate;
		this.updateDate = updateDate;
		this.type = type;
	}
	
	
	
	

}
