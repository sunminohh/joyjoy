package kr.co.sun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sun.domain.AuthVO;
import kr.co.sun.domain.MemberVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.MyReplyList;
import kr.co.sun.dto.PageDTO;
import kr.co.sun.form.MemberJoinForm;
import kr.co.sun.form.MemberUpdateForm;
import kr.co.sun.mapper.MemberMapper;
import kr.co.sun.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/user/*")
public class MemberController {

	private MemberService service;

	@GetMapping("/register")
	public void registerForm(Model model) {

		MemberJoinForm form = new MemberJoinForm();
		model.addAttribute("member", form);
	}

	@PostMapping("/register")
	public String registerAction(@ModelAttribute("member") MemberJoinForm form, SessionStatus sessionStatus,
			RedirectAttributes rttr) {

		MemberVO member = MemberVO.builder().userid(form.getUserid()).userpw(form.getUserpw())
				.userEmail(form.getUserEmail()).userName(form.getUserName()).build();

		AuthVO auth = new AuthVO();
		auth.setAuth("ROLE_USER");
		auth.setUserid(form.getUserid());

		service.insertUser(member);
		service.insertRole(auth);

		sessionStatus.setComplete();

		return "redirect:/user/registered";
	}

	@GetMapping("/registered")
	public void registered() {

	}

	@GetMapping("/profile")
	public void userInfo(String userid, Model model) {

		log.info("/profile?userid = " + userid);
		model.addAttribute("user", service.get(userid));
	}

	@GetMapping("/modify")
	public void modifyForm(String userid, Model model) {

		log.info("/modify?userid= " + userid);
		model.addAttribute("user", service.get(userid));
	}

	@PostMapping("/update")
	public String modifyAction(String userid, MemberUpdateForm form) {

		log.info("/update?userid= " + userid);
		
		service.updateUser(form, userid);
		
		return "redirect:/user/profile?userid=" + userid;
	}
	

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("userid") String userid, HttpServletRequest request) {
		
		log.info("/delete?userid= " + userid);
		service.deleteUser(userid);
		
		// 세션 삭제
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // 세션 무효화
		}
		
		return "redirect:/";
	}

	@PreAuthorize("isAuthenticated() && #userid == authentication.principal.username")
	@GetMapping("/mypost")
	public void list(Pagination page, @RequestParam("userid")String userid, Model model) {
		
		log.info("list: " + page);
		
		int total = service.getTotal(page, userid);
		log.info("total: " + total);
		
		model.addAttribute("list", service.getPost(page, userid));
		model.addAttribute("pageMaker", new PageDTO(page, total));
	}
	
	
	@PreAuthorize("isAuthenticated() && #userid == authentication.principal.username")
	@GetMapping("/myreply")
	public void myReply(Pagination page, @RequestParam("userid")String userid, Model model) {
		
		log.info("replyList: " + page);
		
		int total = service.getRTotal(page, userid);
		log.info("total: " + total);
		
		
		List<MyReplyList> replies = service.getReply(page, userid);
		System.out.println("Model Data:" + replies);
		
		
		model.addAttribute("replyList", service.getReply(page, userid));
		model.addAttribute("pageMaker", new PageDTO(page, total));
	}
	
	
}
