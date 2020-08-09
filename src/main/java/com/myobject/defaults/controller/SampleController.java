package com.myobject.defaults.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myobject.defaults.sample.SampleDTO;
import com.myobject.defaults.sample.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info(this.getClass().getName());
		log.info(new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@GetMapping("/getMapping")
	public void getMappingMetod() {
		log.info(this.getClass().getName());
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
	}

	@GetMapping("/getSample")
	public String getSample(SampleDTO dto) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("\nname is " + dto.getName() + "." + "Age is " + dto.getAge());
		return "sample";
	}

	@GetMapping("/getSample2")
	public String getSample2(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("name is " + name + "." + "Age is " + age);
		return "sample2";
	}

	@GetMapping("/getSampleList")
	public String getSampleList(@RequestParam("ids") ArrayList<String> ids) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[ ids ] : " + ids);
		return "getSampleList";
	}

	@GetMapping("/getSampleList2")
	public String getSampleList2(@RequestParam("ids") String[] ids) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[ ids ] : " + Arrays.asList(ids));
		return "getSampleList2";
	}

	@GetMapping("/getSampleList3")
	public String getSampleList3(SampleDTOList list) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[ list ] : " + list);
		return "getSampleList3";
	}


}
