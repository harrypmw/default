package com.myobject.project;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;
import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.BoardVO;
import com.myobject.project.board.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class BoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Test
	public void testGetList() {

		Pagination pages = new Pagination();
		/*
		pages.setAmount(5);
		pages.setPageNum(1);
		List<BoardVO> list = boardMapper.getListWithPaging(pages);
		list.forEach(boards -> log.info(boards));
		*/
		//boardMapper.getList().forEach(board -> log.info(board));
	}

}
