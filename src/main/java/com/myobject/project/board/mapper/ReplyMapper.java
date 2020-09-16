package com.myobject.project.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO replyVO);

	public ReplyVO read(Long rno);

	public int delete(Long rno);

	public int update(ReplyVO replyVO);

	public List<ReplyVO> pagingList(@Param("pages") Pagination pages, @Param("bno") Long bno);

	public int getTotalCount();
}
