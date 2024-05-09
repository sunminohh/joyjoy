package kr.co.sun.controller;






import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sun.domain.EtcReplyVO;
import kr.co.sun.domain.Pagination;
import kr.co.sun.dto.EtcReplyDTO;
import kr.co.sun.service.EtcReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/etcReplies/")
@RestController
@Log4j
@AllArgsConstructor
public class EtcReplyController {
	
	private EtcReplyService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new", 
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody EtcReplyVO vo) {
		
		log.info("ReplyVO : " + vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT : " + insertCount);
		
		return insertCount == 1 
				? new ResponseEntity<>("success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EtcReplyDTO> getList(@PathVariable("page") int page,
												@PathVariable("bno") Long bno) {
		
		Pagination pagination = new Pagination(page, 10);
		
		log.info("get Reply List bno: " + bno);
		
		log.info(pagination);
		
		return new ResponseEntity<>(service.getListPage(pagination, bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EtcReplyVO> get(@PathVariable("rno") Long rno) {
		
		log.info("rno: " + rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username == #vo.replyer")
	@DeleteMapping(value = "/{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@RequestBody EtcReplyVO vo,
	        						@PathVariable("rno") Long rno) {

	    log.info("remove: " + rno);
	    log.info("replyer: " + vo.getReplyer());

	    return service.remove(rno) == 1 
	    		? new ResponseEntity<>("success", HttpStatus.OK)
	            : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PreAuthorize("principal.username == #vo.replyer")
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH },
			value = "/{rno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody EtcReplyVO vo,
											@PathVariable("rno") Long rno) {
		
		vo.setRno(rno);
		
		log.info("rno: " + rno);
		log.info("modify: " + vo);
		
		return service.modify(vo) == 1
						? new ResponseEntity<>("success", HttpStatus.OK)
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	
}














