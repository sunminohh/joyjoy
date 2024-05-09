package kr.co.sun.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sun.domain.AuthVO;
import kr.co.sun.domain.MemberVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.MyBoardList;
import kr.co.sun.form.MemberUpdateForm;
import kr.co.sun.mapper.MemberMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Setter(onMethod = @__({@Autowired}))
	MemberMapper mapper;
	
	@Override
	public MemberVO get(String userid) {
		
		return mapper.read(userid);
	}
	
	@Override
	public MemberVO getUserById(String userid) {
		
		return mapper.getUserById(userid);
	}
	
	@Override
	public MemberVO getUserByEmail(String userEamil) {
		
		return mapper.getUserByEmail(userEamil);
	}

	@Override
	public void insertUser(MemberVO member) {
		
		String encryptedPassword = passwordEncoder.encode(member.getUserpw());
		member.setUserpw(encryptedPassword);
		
		mapper.insert(member);
	}

	@Override
	public void insertRole(AuthVO auth) {
		
		mapper.insertRole(auth);
	}
	
	
	@Override
	public void kakaoJoin(MemberVO vo) {
		
		mapper.kakaoInsert(vo);
		
		String userid = vo.getUserid();
		log.info("userid : " + userid);
	}
	
	@Override
	public MemberVO kakaoLogin(String snsId) {
		
		log.info("snsId : " + snsId);
		return mapper.kakaoSelect(snsId);
	}
	
	@Override
	public String findUserBySnsId(String snsId) {
		
		return mapper.findUserBySnsId(snsId);
	}
	
	
	@Override
	public void updateUser(MemberUpdateForm form, String userid) {
		
		MemberVO member = mapper.getUserById(userid);
		
		String encryptedPassword = passwordEncoder.encode(form.getUserpw());
		
		member.setUserEmail(form.getUserEmail());
		member.setUserpw(encryptedPassword);
		
		mapper.updateUser(member);
	}
	
	@Transactional
	@Override
	public void deleteUser(String userid) {
		
		mapper.deleteUserRole(userid);
		mapper.deleteUser(userid);
	}

	@Override
	public List<MyBoardList> getList(Pagination page, String userid) {
		
		log.info("get List with pagination: " + page);
		return mapper.getListWithPaging(page, userid);
	}

	@Override
	public int getTotal(Pagination page, String userid) {
		
		log.info("get total count");
		return mapper.getTotalCount(page, userid);
	}

	
 

}
