package com.myobject.defaults.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pagination {

	private int pageNum;
	private int amount;

	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;

	public Pagination() {
		this(1,10);
	}
	public Pagination(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount  = amount;
	}

	public Pagination(int pageNum, int amount, int total) {
		this.pageNum = pageNum;
		this.amount  = amount;
		this.total 	 = total;

		this.endPage = (int) (Math.ceil(pageNum / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		int realEnd = (int)(Math.ceil((total * 1.0) / amount));

		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}


}
