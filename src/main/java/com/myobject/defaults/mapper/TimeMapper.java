package com.myobject.defaults.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT NOW() FROM DUAL")
	public String getTime();

	public String getTimeUsingMapper();
}
