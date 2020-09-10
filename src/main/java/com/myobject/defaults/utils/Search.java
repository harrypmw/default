package com.myobject.defaults.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Search {

	private String type;
	private String keyword;

	public String[] getTypeArr() {

		return type == null ? new String[] {} : type.split("");
	}
}
