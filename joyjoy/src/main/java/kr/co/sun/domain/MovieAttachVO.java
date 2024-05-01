package kr.co.sun.domain;

import lombok.Data;

@Data
public class MovieAttachVO {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	
	private Long bno;
	
}
