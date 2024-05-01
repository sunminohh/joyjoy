package kr.co.sun.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.sun.domain.MemberVO;
import kr.co.sun.mapper.MemberMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService {
	
	@Setter(onMethod = @__({@Autowired}))
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName : " + username);
		
		// userName means userid
		MemberVO vo = memberMapper.read(username);
		
		log.warn("queried by member mapper: " +vo);
		
		return vo == null ? null : new CustomUser(vo);
	}

}
