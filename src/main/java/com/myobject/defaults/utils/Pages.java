package com.myobject.defaults.utils;

import java.util.List;

import com.myobject.project.board.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class Pages {

	public Pagination setPagination(int page, int contentnum, int totalCount) {
		Pagination pagemaker = new Pagination();


		int total = totalCount;

		log.info("[[ total count ]] : " + total);
        int cpagenum = page;
        int ccontentnum = contentnum;

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

        return pagemaker;
	}
}
