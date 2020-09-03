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

	public Pagination() {
		this(1,10);
	}
	public Pagination(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount  = amount;
	}


}
