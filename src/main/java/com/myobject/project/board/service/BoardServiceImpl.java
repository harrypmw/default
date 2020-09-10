package com.myobject.project.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.myobject.defaults.utils.Pagination;
import com.myobject.defaults.utils.Search;
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
	public List<BoardVO> getList(Model model, Pagination pages) {
		log.info(new Object() {}.getClass().getEnclosingMethod().getName());
		Pagination pagemaker = new Pagination();

		pagemaker.setType(pages.getType());
		pagemaker.setKeyword(pages.getKeyword());
		pagemaker.setTypeArr(pages.getType().split(""));

		int total = boardMapper.getTotalCount(pages);

		log.info("[[ total count ]] : " + total);
		log.info(" pages  : " + pages);
        int cpagenum = pages.getPagenum();//Integer.parseInt(pagenum);
        int ccontentnum = pages.getContentnum();//Integer.parseInt(contentnum);

        List<BoardVO> testList = null;

        pagemaker.setTotalcount(total); // mapper 전체 게시글 개수를 지정한다
        pagemaker.setPagenum(cpagenum-1);   // 현재 페이지를 페이지 객체에 지정한다 -1 을 해야 쿼리에서 사용할수 있다
        pagemaker.setContentnum(ccontentnum); // 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
        pagemaker.setCurrentblock(cpagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
        pagemaker.setLastblock(pagemaker.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다.

        pagemaker.prevnext(cpagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
        pagemaker.setStartPage(pagemaker.getCurrentblock()); // 시작 페이지를 페이지 블록번호로 정한다.
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.

        if(ccontentnum == 10){//선택 게시글 수
        	pagemaker.setCountPageNum(pagemaker.getPagenum()*10);
        	pagemaker.setContentnum(pagemaker.getContentnum());
        }else if(ccontentnum == 20){
        	pagemaker.setCountPageNum(pagemaker.getPagenum()*20);
        	pagemaker.setContentnum(pagemaker.getContentnum());
        }else if(ccontentnum ==30){
        	pagemaker.setCountPageNum(pagemaker.getPagenum()*30);
        	pagemaker.setContentnum(pagemaker.getContentnum());
        }
        log.info(pagemaker.getTypeArr().length);
        testList = boardMapper.getListWithPaging(pagemaker);
        log.info(pagemaker.getPagenum());

		model.addAttribute("list",testList);
        model.addAttribute("pageMaker",pagemaker);

		return testList;
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
