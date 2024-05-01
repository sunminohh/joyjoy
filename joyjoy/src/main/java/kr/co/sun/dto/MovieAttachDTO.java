package kr.co.sun.dto;

import lombok.Data;

@Data
public class MovieAttachDTO {

	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	
}
