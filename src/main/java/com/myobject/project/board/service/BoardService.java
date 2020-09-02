package com.myobject.project.board.service;

import java.util.List;

import com.myobject.project.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public boolean delete(Long bno);

	public boolean update(BoardVO board);
}
