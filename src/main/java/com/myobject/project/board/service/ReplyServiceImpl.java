package com.myobject.project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.ReplyVO;
import com.myobject.project.board.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;

	@Override
	public int register(ReplyVO reply) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return replyMapper.insert(reply);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO reply) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return replyMapper.update(reply);
	}

	@Override
	public int remove(Long rno) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Pagination pages, Long bno) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return replyMapper.pagingList(pages, bno);
	}

}
