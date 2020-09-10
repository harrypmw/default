package com.myobject.project.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myobject.defaults.utils.Pagination;
import com.myobject.defaults.utils.Search;
import com.myobject.project.board.domain.BoardVO;

public interface BoardMapper {

	//@Select("SELECT * FROM TBL_BOARD WHERE BNO >= 0")
	public List<BoardVO> getList();

	//public List<BoardVO> getListWithPaging(@Param("pagenum") int pagenum, @Param("contentnum") int contentnum, Search search);
	public List<BoardVO> getListWithPaging(Pagination pages);

	public void insert(BoardVO BOARD);

	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotalCount(Pagination pages);
}
