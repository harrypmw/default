package com.myobject.defaults.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myobject.defaults.sample.SampleDTO;
import com.myobject.defaults.sample.SampleDTOList;
import com.myobject.defaults.sample.ToDoDTO;

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
	/*
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dt = new Date();
		binder.registerCustomEditor(dt.getClass(), new CustomDateEditor(sdf, false));
	}
	*/
	@GetMapping("/timeSmple")
	public String timeSample(ToDoDTO dto) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[ ToDoDTO ] : " + dto);
		return "timeSmple";
	}

	@GetMapping("/timeSmple2")
	public String timeSample2(ToDoDTO dto) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[ ToDoDTO2 ] : " + dto);
		return "timeSmple2";
	}

	@GetMapping("/sampleTest")
	public String sampleTest(Model model, SampleDTO dto, int page) {
		model.addAttribute("page", page);
		model.addAttribute("sampleDTO", dto);
		//return "/sample/sampleTest";
		return "/sample/sampleTest";
	}

	@GetMapping("/jacksonTest")
	public @ResponseBody SampleDTO jacksonTest() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("Harry");
		return dto;
	}

	@GetMapping("/rsEntitiy")
	public ResponseEntity<String> rsEntitiy(){
		String msg = "{\"name\": \"HARRY\", \"age\":\"28\"}";
		String msgArray = "{\"HARRY\":[\"name\":\"HARRY\"]\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(msgArray, header, HttpStatus.OK);
	}
	@GetMapping("/sampleUpload")
	public void sampleUpload() {

	}

	@PostMapping("/uploadTest")
	public void uploadTest(ArrayList<MultipartFile> files) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName()+" Start");
		files.forEach(file ->{
			log.info("-------------------------------------------------------");
			log.info("file Name : " + file.getOriginalFilename());
			log.info("file Size : " + file.getSize());
			log.info("-------------------------------------------------------");
		});
		log.info(new Object() {}.getClass().getEnclosingMethod().getName()+" END");
	}
}
