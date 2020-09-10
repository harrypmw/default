package com.myobject.project.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myobject.defaults.utils.Pagination;
import com.myobject.defaults.utils.Search;
import com.myobject.project.board.domain.BoardVO;
import com.myobject.project.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;

	/*
	@GetMapping("/list")
	public void list(Model model) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		model.addAttribute("list", boardService.getList());
	}
	*/

	@GetMapping("/list")
	public void list(Model model,
					 @RequestParam(defaultValue = "1") String pagenum,
					 @RequestParam(defaultValue = "10") String contentnum,
					 @RequestParam(defaultValue = "") String type,
					 @RequestParam(defaultValue = "") String keyword
			) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());

		log.info("[[ pagenum ]] : " + pagenum);
		log.info("[[ contentnum ]] : " + contentnum);
		Pagination pages = new Pagination();
		pages.setPagenum(Integer.parseInt(pagenum));
		pages.setContentnum(Integer.parseInt(contentnum));
		pages.setType(type);
		pages.setKeyword(keyword);

		boardService.getList(model, pages);
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		boardService.insert(board);
		log.info(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}

	@GetMapping("/register")
	public void register() {

	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("pages") Pagination pages) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ bno ]] : " + bno);
		log.info("[[ pagenum ]] : " + pages.getPagenum());
		log.info("[[ contentnum ]] : " + pages.getContentnum());
		model.addAttribute("board", boardService.read(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, Pagination pages) {
  //public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("pages") Pagination pages) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ board ]] : " + board);
		log.info("[[ pagenum ]] : " + pages.getPagenum());
		log.info("[[ contentnum ]] : " + pages.getContentnum());

		if (boardService.update(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		/*
		rttr.addFlashAttribute("pagenum", pages.getPagenum());
		rttr.addFlashAttribute("contentnum", pages.getContentnum());
		rttr.addFlashAttribute("type", pages.getType());
		rttr.addFlashAttribute("keyword", pages.getKeyword());
		*/
		return "redirect:/board/list" + pages.getListLik();
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, @ModelAttribute("pages") Pagination pages) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ bno ]] : " + bno);
		log.info("[[ pagenum ]] : " + pages.getPagenum());
		log.info("[[ contentnum ]] : " + pages.getContentnum());

		if (boardService.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addFlashAttribute("pagenum", pages.getPagenum());
		rttr.addFlashAttribute("contentnum", pages.getContentnum());
		rttr.addFlashAttribute("type", pages.getType());
		rttr.addFlashAttribute("keyword", pages.getKeyword());
		return "redirect:/board/list";
	}
}
