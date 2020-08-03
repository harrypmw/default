package com.myobject.defaults.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myobject.defaults.config.RootConfig.class})
@Log4j
public class TimeMapperTest {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void timeTest() {
		log.info("==================================");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTimeUsingMapper());
		log.info(timeMapper.getTime());
		log.info("==================================");
	}

}
