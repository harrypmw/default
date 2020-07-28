package com.myobject.defaults.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {

	@NonNull
	private Chef chef;

	/*
	 * @AllArgConstructor 어노테이션을 사용하면 생성자는 필요없음.
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	*/
}
