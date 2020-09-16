package com.myobject.project.board.service;

import java.util.List;

import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO reply);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO reply);

	public int remove(Long rno);

	public List<ReplyVO> getList(Pagination pages, Long bno);

	public int getTotalCount();
}
