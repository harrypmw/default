package com.myobject.project.reply;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;
import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.ReplyVO;
import com.myobject.project.board.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class})
@Log4j
public class ReplyMapperListTest {

	private Long[] bnoArr = {425L, 424L, 423L, 422L, 421L};

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;

	@Test
	public void test() {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		Pagination pages = new Pagination();

		List<ReplyVO> replies = replyMapper.pagingList(pages, bnoArr[0]);
		replies.forEach(list -> {
			log.info(list);
		});
	}
}
