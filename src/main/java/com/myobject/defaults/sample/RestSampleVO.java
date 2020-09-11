package com.myobject.defaults.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestSampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
}
