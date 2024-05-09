package kr.co.sun.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sun.domain.AuthVO;
import kr.co.sun.domain.MemberVO;
import kr.co.sun.security.CustomUser;
import kr.co.sun.service.KakaoService;
import kr.co.sun.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class KakaoController {

	private KakaoService kakaoService;
	private MemberService memberService;
	
	@RequestMapping(value="/kakao/callback", method = RequestMethod.GET)
	public String redirectKakao(@RequestParam("code") String code, HttpSession session) throws IOException{
		log.info("code::" +code);
		
		// 접속토큰 get
		String kakaoToken = kakaoService.getReturnAccessToken(code);
		log.info("kakaoToken :: " + kakaoToken);
		
		// 접속자 정보 get
		Map<String, Object> result = kakaoService.getUserInfo(kakaoToken);
		log.info("result : " + result);
		String snsId = (String)result.get("id");
		String userName = (String)result.get("nickname");
		String email = (String)result.get("email");
		String userpw = snsId;
		log.info(snsId);
		
		// 분기
		MemberVO memberVo = new MemberVO();
		// 일치하는 snsId 없을 시 회원가입
		if(memberService.kakaoLogin(snsId) == null) {
			
			log.warn("카카오로 회원가입");
			
			String userid = email.substring(0, email.indexOf('@'));
			memberVo.setUserid(userid);
			memberVo.setUserpw(userpw);
			memberVo.setUserName(userName);
			memberVo.setSnsId(snsId);
			memberVo.setUserEmail(email);
			memberService.kakaoJoin(memberVo);
			
			AuthVO auth = new AuthVO();
			auth.setUserid(userid);
			auth.setAuth("ROLE_USER");
			
			memberService.insertRole(auth);
		}
		
		// 일치하는 snsId가 있으면 멤버객체에 담음
		log.warn("카카오로 로그인");
		String userid = memberService.findUserBySnsId(snsId);
		log.info("findUserBySnsId: " +userid);
		MemberVO vo = memberService.getUserById(userid);
		log.warn("member : " +vo);
		CustomUser user = new CustomUser(vo);
		log.warn("user : " + user);
		List<GrantedAuthority> roles = user.getList(vo);
	 	Authentication auth = new UsernamePasswordAuthenticationToken(user, null, roles);
		log.warn("auth : " + auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		// 로그아웃 처리시 사용할 토큰 값
		session.setAttribute("kakaoToken", kakaoToken);
		
		return "redirect:/";
	}
}
