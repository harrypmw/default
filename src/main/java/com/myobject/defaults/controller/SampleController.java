package com.myobject.defaults.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info(this.getClass().getName());
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@GetMapping("/getMapping")
	public void getMappingMetod() {
		log.info(this.getClass().getName());
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
	}
}
