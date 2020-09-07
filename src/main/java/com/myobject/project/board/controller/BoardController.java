package com.myobject.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myobject.defaults.utils.Pagination;
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
	public void list(Pagination pages, Model model) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		int total = boardService.getTotal(pages);

		log.info("[[ total count ]] : " + total);
		model.addAttribute("list", boardService.getList(pages));
		model.addAttribute("pageMaker", new Pagination(pages.getPageNum(), pages.getAmount(), total));
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
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ bno ]] : " + bno);
		model.addAttribute("board", boardService.read(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ board ]] : " + board);

		if (boardService.update(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("[[ bno ]] : " + bno);

		if (boardService.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
