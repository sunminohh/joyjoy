package kr.co.sun.service;

import java.util.List;

import kr.co.sun.domain.AuthVO;
import kr.co.sun.domain.MemberVO;
import kr.co.sun.domain.MyPagination;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.MyBoardList;
import kr.co.sun.form.MemberUpdateForm;

public interface MemberService {
	
	public MemberVO get(String userid);
	
	public MemberVO getUserById(String userid);
	
	public MemberVO getUserByEmail(String userEamil);

	public void insertUser(MemberVO member);
	
	public void insertRole(AuthVO auth);
	
	
	public void kakaoJoin(MemberVO vo);
	
	public MemberVO kakaoLogin(String snsId);
	
	public String findUserBySnsId(String snsId);
	
	
	public void updateUser(MemberUpdateForm form, String userid);
	
	public void deleteUser(String userid);
	

	public List<MyBoardList> getList(MyPagination page);
	
	public int getTotal(MyPagination page);
}
