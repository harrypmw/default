package com.myobject.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;
import com.myobject.project.board.domain.BoardVO;
import com.myobject.project.board.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class BoardMapperUpdateTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Test
	public void testGetList() {
		BoardVO board = new BoardVO();
		board.setContent("New Content");
		board.setTitle("New Title");
		board.setWriter("Harry Park");
		board.setBno(7L);
		boardMapper.update(board);
		log.info(board);
	}

}
