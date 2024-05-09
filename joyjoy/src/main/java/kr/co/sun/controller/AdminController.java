package kr.co.sun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.PageDTO;
import kr.co.sun.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	private AdminService service;
	
	@RequestMapping("/board")
	public String boardList(Pagination page, Model model) {
		
		log.info("boardList: " + page);
		model.addAttribute("boardList", service.getBoardList(page));
		
		int total = service.getTotal(page);
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(page, total));
		
		return "/admin/board";
	}
	
	@RequestMapping("/reply")
	public String replyList(Pagination page, Model model) {
		
		log.info("replyList: " + page);
		int total = service.getRTotal(page);
		log.info("total: " + total);
		
		model.addAttribute("replyList", service.getReplyList(page));
		model.addAttribute("pageMaker", new PageDTO(page, total));
		
		return "/admin/reply";
	}
	
	

}
