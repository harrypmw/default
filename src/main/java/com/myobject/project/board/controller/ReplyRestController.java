package com.myobject.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myobject.project.board.domain.ReplyVO;
import com.myobject.project.board.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyRestController {

	@Setter(onMethod_ = {@Autowired})
	private ReplyService replyService;

	@PostMapping(value = "/new"
				, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}
				, produces = {MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		log.info("------" + new Object(){}.getClass().getEnclosingMethod().getName() + "------");

		int result = replyService.register(replyVO);
		log.info("[ result ] : " + result);

		return result == 1 ?
			new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}



}
