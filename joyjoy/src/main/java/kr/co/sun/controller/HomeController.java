package kr.co.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sun.service.HomeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/")
@Controller
public class HomeController {
	
	private HomeService service;
	
	@RequestMapping("")
    public String home(Model model) {
		
		model.addAttribute("movieList", service.getMovieList());
		model.addAttribute("gameList", service.getGameList());
		model.addAttribute("bookList", service.getBookList());
		model.addAttribute("etcList", service.getEtcList());
		
		return "home";
    }
	
}
