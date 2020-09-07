package com.myobject.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;
import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.BoardVO;
import com.myobject.project.board.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class BoardServiceTest {

	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;

	@Test
	public void boardTest() {
		/*
		// InsertSelectKey 테스트
		BoardVO board = new BoardVO();
		board.setTitle("New Title");
		board.setContent("New Content");
		board.setWriter("HARRY");

		boardService.insert(board);
		log.info("[[ board bno ]] : " + board.getBno());
		*/
		boardService.getList(new Pagination(2,3)).forEach(boards -> log.info(boards));

		Long bno = 6L;
		BoardVO read = boardService.read(bno);
		log.info(read);

		boolean result = boardService.update(read);
		log.info("[[ result ]] : " + result);
		result = boardService.delete(bno);
		log.info("[[ result ]] : " + result);
	}
}
