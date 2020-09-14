package com.myobject.project.reply;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;
import com.myobject.project.board.domain.ReplyVO;
import com.myobject.project.board.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class})
@Log4j
public class ReplyMapperInsertTest {

	private Long[] bnoArr = {425L, 424L, 423L, 422L, 421L};
	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;

	@Test
	public void test() {
		log.info(" ------" + new Object() {}.getClass().getEnclosingMethod().getName() + " ------");

		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			reply.setBno(bnoArr[ i % 5]);
			reply.setReply("Reply test " + i);
			reply.setReplyer("Replyer " + i);
			log.info(replyMapper.insert(reply));

		});
		log.info(" ------" + new Object() {}.getClass().getEnclosingMethod().getName() + " ------");
	}
}
