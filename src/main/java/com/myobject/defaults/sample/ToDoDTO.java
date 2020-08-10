package com.myobject.defaults.sample;

import lombok.Data;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ToDoDTO {

	private String title;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
}
