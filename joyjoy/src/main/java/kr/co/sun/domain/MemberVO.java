package kr.co.sun.domain;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {

	private String userid;
	private String userpw;
	private String userName;
	private String userEmail;
	private boolean enabled;
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;
	
	private String snsId;
	
	@Builder
	public MemberVO(String userid, String userpw, String userName, String userEmail, boolean enabled, Date regDate,
			Date updateDate, List<AuthVO> authList, String snsId) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.enabled = enabled;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.authList = authList;
		this.snsId = snsId;
	}
	
	
	
}
