package kr.co.sun.domain;

import org.springframework.web.util.UriComponentsBuilder;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyPagination {

	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	private String writer;
	
	public MyPagination() {
		this(1, 10);
	}
	
	public MyPagination(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	} 
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
	
	 public void setWriter(String writer) {
	        this.writer = writer;
	 }
	
}
