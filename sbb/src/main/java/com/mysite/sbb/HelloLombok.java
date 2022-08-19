package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// 생성자 자동생성
@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
//		HelloLombok helloLombok = new HelloLombok();
//		helloLombok.setHello("헬로롬복");
//		helloLombok.setLombok(5);
		HelloLombok helloLombok = new HelloLombok("헬로롬복", 0);
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
