package kr.co.sun.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {

	private int Cno;
	private String name;
	
	@Builder
	public Category(int cno, String name) {
		super();
		this.Cno = cno;
		this.name = name;
	}
	
}
