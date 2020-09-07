package com.myobject.project.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myobject.defaults.utils.Pagination;
import com.myobject.project.board.domain.BoardVO;
import com.myobject.project.board.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	/*
	@AllArgsConstructor를 사용하지 않는다면, @Setter 혹은 @Autowired사용해야함.
	 * */
	private BoardMapper boardMapper;

	/*
	@Override
	public List<BoardVO> getList() {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return boardMapper.getList();
	}
	*/
	@Override
	public List<BoardVO> getList(Pagination pages) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		return boardMapper.getListWithPaging(pages);
	}

	@Override
	public void insert(BoardVO board) {
		log.info("register" + board);
		boardMapper.insertSelectKey(board);
	}

	@Override
	public void insertSelectKey(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO read(Long bno) {
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
		return boardMapper.read(bno);
	}

	@Override
	public boolean delete(Long bno) {
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
		return boardMapper.delete(bno) == 1;
	}

	@Override
	public boolean update(BoardVO board) {
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
		return boardMapper.update(board) == 1;
	}

	@Override
	public int getTotal(Pagination pages) {
		log.info(new Object(){}.getClass().getEnclosingMethod().getName());
		return boardMapper.getTotalCount(pages);
	}

}
